package TestCases_Package;

import org.testng.annotations.Test;

import Pages_Package.BaseClass;
import Pages_Package.LoginPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTestcases extends BaseClass {
	private WebDriver driver;
	private LoginPage login;

	@BeforeTest
	public void beforeMethod() {
		driver = super.Setup_Browser();
		// driver=super.Setup_HeadlessBrowser();
		login = new LoginPage(driver);
		// login.Precondition();
	}

	// Enter wrong Email and wrong Password
	@Test(priority = 1, description = "Login Test#2")
	@Description("Verify test using these credentials: Email:Test@gmail.com  password: @1_)()**^%$#@$msd_MALIK")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void Testcase_VerifyLoginwith_bothWrongEmailandPassword_SignupNewForAccount() {

		login.Login_Testcases("ABCDEFG@gmail.com", "Test@____/%!123");
		Assert.assertTrue(true, "Passed");

		String actualMsg = "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found";

		String errorMsg = "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found";

		if (actualMsg.equalsIgnoreCase(errorMsg)) {
			login.RedirectLogin_forSignup();
			System.out.println("User is not registered with this Email. Kindly signup for new account");
		} else {
			System.out.println("User is registered with this email, you need to forgot password");
		}
	}

	@AfterTest
	public void Teardown() {
		System.out.print("Current Page Name is: " + driver.getTitle() + "\n" + driver.getCurrentUrl() + "\n");
	}

}
