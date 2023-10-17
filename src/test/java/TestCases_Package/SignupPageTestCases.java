package TestCases_Package;

import org.testng.annotations.Test;

import Pages_Package.BaseClass;
import Pages_Package.SignupPage;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SignupPageTestCases extends BaseClass {
	public WebDriver driver;
	private SignupPage register;

	@BeforeTest
	public void initiateBrowser() {
		driver = super.Setup_Browser();
		// driver=super.Setup_HeadlessBrowser();
		register = new SignupPage(driver);
		register.Precondition();
	}

	@Test
	public void Testcases_ToRegisterUserSuccessfully() throws IOException {

		register.Precondition();
		register.SignUp_Form("Test", "user", "Test2667@gmail.com", "TestComp", "Test@123", "Test@123");

		register.SignUp_Form("Test", "user", "Test3@gmail.com", "TestComp", "Test@123", "Test@123");

		// Verify page title is matched "nopCommerce demo store"
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");

		String actual_url = driver.getCurrentUrl();
		String expected_url = "https://demo.nopcommerce.com/";
		Assert.assertEquals(actual_url, expected_url);
		if (actual_url == expected_url) {
			driver = super.TakeScreenshot(driver, "Imagescreenshot");
		}
	}

	@AfterTest
	public void Teardown() {
		System.out.print("Current Page Name is: " + driver.getTitle() + "\n" + driver.getCurrentUrl() + "\n");
	}
}
