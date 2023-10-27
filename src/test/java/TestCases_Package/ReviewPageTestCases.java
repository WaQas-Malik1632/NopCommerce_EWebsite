package TestCases_Package;

import org.testng.annotations.Test;
import Pages_Package.BaseClass;
import Pages_Package.LoginPage;
import Pages_Package.ProductReviewsPage;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ReviewPageTestCases extends BaseClass {
	private WebDriver driver;
	private LoginPage login;
	private SignupPage register;
	private ProductReviewsPage reviews;

	@BeforeTest
	public void initiateBrowser() {
		driver = super.Setup_Browser();
		// driver=super.Setup_HeadlessBrowser();
		login = new LoginPage(driver);
		login.Precondition();
		login.Login_Testcases("Test123@gmail.com", "Test@123");
		register = new SignupPage(driver);
		reviews = new ProductReviewsPage(driver);
	}
	
	@Test(priority = 1, description = "Review_TC001", enabled = true, invocationCount = 1)
	@Description("Verify test logged in user is able to place order for the custom desktop")
	@Epic("Review_EP001")
	@Feature("Review_001")
	@Story("Verify test logged in user is able to submit the Review successfully")
	@Step("Login>>Home>>Select Computers Category>>Select Build own computer>>")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void userIsAbletoPlaceOrderForCustomDesktop() throws InterruptedException {
		reviews.CustomDesktopOrder();
		
		
	}
	

	@Test(priority = 1, description = "Review_TC002", enabled = false, invocationCount = 1)
	@Description("Verify test logged in user is able to submit the Review successfully")
	@Epic("Review_EP001")
	@Feature("Review_002")
	@Story("Verify test logged in user is able to submit the Review successfully")
	@Step("Login>>Home>>Select Computers Category>>Select Apple Notebook>>Select Any Apple Product>>Add Review>>Submit Review")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void userIsAbleToSubmittReviweForDesktop() throws InterruptedException {

		reviews.AddReviewsOfDesktop("DeskTop Review", "Its been Fantastic experience of using Desktop system");

		// To verify the sessionID
		String sessionID = ((ChromeDriver) driver).getSessionId().toString();

		if (sessionID == null) {
			login.Login_Testcases("Testuser@gmail.com", "Test@123");
			// Print the session ID
			System.out.println("Session ID: " + sessionID);
		} else if (register.SignUp_Form("Test", "user", "Test3@gmail.com", "TestComp", "Test@123", "Test@123")) {
			// user doesnot exists in our system then user should be able to signin first
		}

		System.out.print("Page Title is:" + driver.getTitle() + "/n");
		String Actual_Url = driver.getCurrentUrl();
		String Expected_Url = "https://demo.nopcommerce.com/productreviews/3";
		if (Expected_Url == Actual_Url) {
			Assert.assertTrue(true, "Reviews has been successfully submitted");

		}
	}

	@AfterTest
	public void Teardown() {
//		if (driver != null) {
//			driver.quit();
//		}
		System.out.print("Current Page Name is: " + driver.getTitle() + "\n" + driver.getCurrentUrl() + "\n");

	}
}
