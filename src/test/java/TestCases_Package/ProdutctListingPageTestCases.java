package TestCases_Package;

import org.testng.annotations.Test;

import Pages_Package.LoginPage;
import Pages_Package.SignupPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class ProdutctListingPageTestCases {

	private WebDriver driver;
	private LoginPage login;
	private SignupPage register;

	@BeforeTest
	public void initiateBrowser() {
	}

	@Test
	public void Testcase() {
	}

	@AfterTest
	public void TearDown() {
		System.out.print("Current Page Title is: " + driver.getTitle() + "\n" + driver.getCurrentUrl() + "\n");
	}

}
