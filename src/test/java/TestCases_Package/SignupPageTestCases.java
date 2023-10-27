package TestCases_Package;

import org.testng.annotations.Test;

import Pages_Package.BaseClass;
import Pages_Package.SignupPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

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

	@Test(priority = 1, description = "Signup TC001", enabled = true, invocationCount = 1)
	@Description("Verify that user is able to register himself successfully")
	@Epic("Singup_EP001")
	@Feature("Signup_001")
	@Story("Verify that user is able to register himself successfully")
	@Step("Signup>>Home page")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void Testcases_ToRegisterUserSuccessfully() throws IOException {

		register.Precondition();
		register.SignUp_Form("Test", "user", "Test2667@gmail.com", "TestComp", "Test@123", "Test@123");

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
