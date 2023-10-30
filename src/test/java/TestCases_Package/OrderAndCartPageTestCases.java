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

	@Test(priority = 1, description = "Order_TC001", enabled = true, invocationCount = 1)
	@Description("Verify that user is able to place order of Apple Note Book sucessfully")
	@Epic("Order_EP001")
	@Feature("Order_001")
	@Story("Verify that user is able to place order of Apple Note Book sucessfully")
	@Step("Login>>Home>>Select Computers Category>>Select Apple Notebook>>Select Any Apple Product")
	@Severity(SeverityLevel.CRITICAL)
	@Attachment()
	public void VerifyplaceOrderOfAppleLaptop() throws InterruptedException {
		order.PlaceOrderofAppleNotebook();
		order.viewCart();
	}

	@Test(priority = 1, description = "Order_TC002", enabled = true, invocationCount = 1)
	@Description("Verify that user is able to update the Shopping Cart Successfully")
	@Epic("Order_EP001")
	@Feature("Order_002")
	@Story("Verify that user is able to update the Shopping Cart Successfully")
	@Step("Login>>Home>>Select Computers Category>>Select Apple Notebook>>Select Any Apple Product>>Update No of Items>>Update the cart")
	@Severity(SeverityLevel.BLOCKER)
	@Attachment()
	public void VerifythatUserIsAbleToUpdateShoppingCart() throws InterruptedException {
		order.PlaceOrderofAppleNotebook();
		order.updateCart();
		// String ExpectedUrl="https://demo.nopcommerce.com/cart";
		// Assert.assertEquals(true, driver.getCurrentUrl()==ExpectedUrl);
	}

	@Test(priority = 1, description = "Order_TC003", enabled = true, invocationCount = 1)
	@Description("Verify that user is able to place order of Mobile sucessfully")
	@Epic("Order_EP001")
	@Feature("Order_003")
	@Story("Verify that user is able to place order of Mobile sucessfully")
	@Step("Login>>Home>>Select Mobile Phone Category>>Select Any Apple Product")
	@Severity(SeverityLevel.NORMAL)
	@Attachment()
	public void VerifyplaceOrderofMobilePhone() throws InterruptedException {
		order.PlaceOrderofNokiaPhone();
		// order.viewCart();
		// String ExpectedUrl="https://demo.nopcommerce.com/cart";
		// Assert.assertEquals(true, driver.getCurrentUrl()==ExpectedUrl);
	}

	@Test(priority = 1, description = "Order_TC004", enabled = true, invocationCount = 1)
	@Description("Verify that user is able to place order of Desktop sucessfully")
	@Epic("Order_EP001")
	@Feature("Order_004")
	@Story("Verify that user is able to place order of Desktop sucessfully")
	@Step("Login>>Home>>Select Computers Category>>Select SubCategory Desktop>>Select Any Desktop Product")
	@Severity(SeverityLevel.MINOR)
	@Attachment()
	public void VerifyplaceOrderOfDesktop() throws InterruptedException {
		order.PlaceOrderofDesktop();
		order.viewCart();
		// String ExpectedUrl="https://demo.nopcommerce.com/cart";
		// Assert.assertEquals(true, driver.getCurrentUrl()==ExpectedUrl);
	}

	@AfterTest
	public void Teardown() {
		System.out.print("Current Page Title is: " + driver.getTitle() + "\n" + driver.getCurrentUrl() + "\n");
	}

}
