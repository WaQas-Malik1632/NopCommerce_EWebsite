package TestCases_Package;
import org.testng.annotations.Test;
import Pages_Package.BaseClass;
import Pages_Package.LoginPage;
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
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class LoginTestcases extends BaseClass {
	private WebDriver driver;
	private LoginPage login;
	private SignupPage register;

	@BeforeTest
	public void initiateBrowser() {
		driver = super.Setup_Browser();
//		driver=super.Setup_HeadlessBrowser();
		login = new LoginPage(driver);
		register = new SignupPage(driver);
		register.Precondition();
	}

	@Test(priority = 1, description = "Login_TC001", enabled = true, invocationCount = 5)
	@Description("Verify test using these credentials: Email:Tteesstt@gmail.com  password: @1**^%$#@$_MALIK")
	@Epic("Login_EP001")
	@Feature("Login001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.NORMAL)
	@Attachment()
	public void Testcase_VerifyLoginwith_bothWrongEmailandPassword() {
		login.Precondition();
		login.Login_Testcases("Test@gmail.com ", "@1**^%$#@$_MALIK");

		driver.manage().timeouts().pageLoadTimeout(05, TimeUnit.SECONDS);

		// To validate whether user is successfully Registered or not
		String ExpectedUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
		if (driver.getCurrentUrl() == ExpectedUrl) {
			Assert.assertTrue(true, "Test Passed");
		}
	}

	@Test(priority = 2, description = "Login_TC002", enabled = true, invocationCount = 1)
	@Description("Verify test using these credentials: Email:Testuser@gmail.com  password:Test@123")
	@Epic("EP001")
	@Feature("Login002")
	@Story("Login Test")
	@Step("Use basic steps for login")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void Testcase_VerifyLoginwith_bothCorrectEmailandPassword() {
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

		login.Precondition();
		login.Login_Testcases("Testuser@gmail.com", "Test@123");
		String ExpectedUrl = "https://demo.nopcommerce.com/";
		if (driver.getCurrentUrl() == ExpectedUrl) {
			Assert.assertTrue(true, "Test Passed");
		}
	}

	// Enter wrong Email and wrong Password
	@Test(priority = 3, description = "Login_TC003", enabled = true, invocationCount = 1)
	@Description("Verify test using these credentials: Email:Test@gmail.com  password: @1_)()**^%$#@$msd_MALIK")
	@Epic("EP001")
	@Feature("Login003")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void usingSession_VerifyUserDoesnotExistInSystem_SignupNewForAccount() {
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		login.Precondition();
		login.Login_Testcases("ABCDEsFG@gmail.com", "Test@dj/%!123");
		// Assert.assertTrue(true, "Passed");

		// To verify the sessionID
		String sessionID = ((ChromeDriver) driver).getSessionId().toString();

		System.out.println("Session ID->" + sessionID);

		if (sessionID == null) {
			System.out.println("User is not registered with this Email. Kindly signup for new account");
			// User doesnot exists in our system then user should be able to Signin first

			register.Precondition();
			register.SignUp_Form("Test", "user", "Test3@gmail.com", "TestComp", "Test@123", "Test@123");
		}
	}

	// Enter wrong Email and wrong Password
	@Test(priority = 4, description = "Login_TC004", enabled = true, invocationCount = 1)
	@Description("Verify test using these credentials: Email:Test@gmail.com  password: @1_)()**^%$#@$msd_MALIK")
	@Epic("EP001")
	@Feature("Login004")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void Verify_UserDoesnotExistInSystem_SignupNewForAccount() {
		// throw new SkipException("Skipped");

		driver.manage().timeouts().pageLoadTimeout(05, TimeUnit.SECONDS);

		login.Precondition();
		login.Login_Testcases("usernewtest@gmail.com", "ZXCv@123");

		// ==== Validate user is logged in or not using Error messages====

		String actualMsg = "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found";
		String errorMsg = "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found";

		if (actualMsg.equalsIgnoreCase(errorMsg)) {

			System.out.println("User is not registered with this Email. Kindly signup for new account");
			register.Precondition();
			register.SignUp_Form("Tester", "usernew", "Test43@gmail.com", "TestCompany", "Test@123", "Test@123");

		} else {
			System.out.println("User is registered with this email, you need to forgot password");
		}

		// To check whether user is successfully Registered or not
		String ExpectedUrl = "https://demo.nopcommerce.com/";
		if (driver.getCurrentUrl() == ExpectedUrl) {
			Assert.assertTrue(true, "Test Passed");
			try {
				super.TakeScreenshot(driver, "TestScreenshot.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@AfterTest
	public void Teardown() {
		System.out.print("Current Page Title is: " + driver.getTitle() + "\n" + driver.getCurrentUrl() + "\n");
//		if (driver != null) {
//			driver.quit();
//		}
	}
}
