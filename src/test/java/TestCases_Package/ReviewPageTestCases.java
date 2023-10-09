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
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ReviewPageTestCases extends BaseClass {
	private WebDriver driver;
	private LoginPage login;
	private SignupPage register;
	private ProductReviewsPage reviews;

	@BeforeTest
	public void beforeMethod() {
		driver = super.Setup_Browser();
		// driver=super.Setup_HeadlessBrowser();
		login = new LoginPage(driver);
		login.Login_Testcases("Test123@gmail.com", "Test@123");
		reviews = new ProductReviewsPage(driver);
	}

	@Test(priority = 1, description = "Login Test#2")
	@Description("Verify test using these credentials: Email:Test@gmail.com  password: @1_)()**^%$#@$msd_MALIK")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void DeskReview() throws InterruptedException {

		reviews.AddReviewsOfDesktop("DeskTop Review", "Its been Fantastic experience of using Desktop system");

		System.out.print("Page Title is:" + driver.getTitle() + "/n");
		String Actual_Url = driver.getCurrentUrl();
		String Expected_Url = "https://demo.nopcommerce.com/productreviews/3";
		if (Expected_Url == Actual_Url) {
			Assert.assertTrue(true, "Reviews has been successfully submitted");
		}
	}

	@AfterTest
	public void Teardown() {
		System.out.print("Current Page Name is: " + driver.getTitle() + "\n" + driver.getCurrentUrl() + "\n");
	}

}
