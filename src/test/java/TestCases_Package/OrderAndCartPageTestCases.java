package TestCases_Package;

import org.testng.annotations.Test;

import Pages_Package.BaseClass;
import Pages_Package.OrderAndCartPage;
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

public class OrderAndCartPageTestCases extends BaseClass {
	private WebDriver driver;
	public OrderAndCartPage order;

	@BeforeTest
	public void initiateBrowser() {
		driver = super.Setup_Browser();
		// driver=super.Setup_HeadlessBrowser();
		order = new OrderAndCartPage(driver);
	}
	@Test(priority = 1, description = "Order Test#1", enabled = true, invocationCount = 1)
	@Description("Verify test using these credentials: Email:Tteesstt@gmail.com  password: @1**^%$#@$_MALIK")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void VerifyplaceOrderOfAppleLaptop() throws InterruptedException {
		order.PlaceOrderofAppleNotebook();
		order.viewCart();

	}
	@Test(priority = 1, description = "Order Test#2", enabled = false, invocationCount = 1)
	@Description("Verify test using these credentials: Email:Tteesstt@gmail.com  password: @1**^%$#@$_MALIK")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void VerifythatUserIsAbleToUpdateShoppingCart() throws InterruptedException {
		order.PlaceOrderofAppleNotebook();
		order.updateCart();
	//	String ExpectedUrl="https://demo.nopcommerce.com/cart";
	//	Assert.assertEquals(true, driver.getCurrentUrl()==ExpectedUrl);
	}

	@Test(priority = 1, description = "Order Test#3", enabled = false, invocationCount = 1)
	@Description("Verify test using these credentials: Email:Tteesstt@gmail.com  password: @1**^%$#@$_MALIK")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void VerifyplaceOrderofMobilePhone() throws InterruptedException {
		order.PlaceOrderofNokiaPhone();
	//	order.viewCart();
	//	String ExpectedUrl="https://demo.nopcommerce.com/cart";
	//	Assert.assertEquals(true, driver.getCurrentUrl()==ExpectedUrl);
	}

	@Test(priority = 1, description = "Order Test#4", enabled = false, invocationCount = 1)
	@Description("Verify test using these credentials: Email:Tteesstt@gmail.com  password: @1**^%$#@$_MALIK")
	@Epic("EP001")
	@Feature("Feature:001")
	@Story("Login Test")
	@Step("Use basic steps")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void VerifyplaceOrderOfDesktop() throws InterruptedException {
		order.PlaceOrderofDesktop();
		order.viewCart();
	//	String ExpectedUrl="https://demo.nopcommerce.com/cart";
	//	Assert.assertEquals(true, driver.getCurrentUrl()==ExpectedUrl);
	}

	@AfterTest
	public void Teardown() {
		System.out.print("Current Page Name is: " + driver.getTitle() + "\n" + driver.getCurrentUrl() + "\n");
	}

}
