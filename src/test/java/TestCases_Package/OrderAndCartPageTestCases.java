package TestCases_Package;

import org.testng.annotations.Test;

import Pages_Package.BaseClass;
import Pages_Package.OrderAndCartPage;
import Pages_Package.SignupPage;

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

	@Test
	public void VerifyplaceOrderofComputer() throws InterruptedException {
		// order.PlaceOrderofDesktop();
		order.PlaceOrderofAppleNotebook();
		order.PlaceOrderofNokiaPhone();
		order.viewCart();
	}

	@AfterTest
	public void Teardown() {
		System.out.print("Current Page Name is: " + driver.getTitle() + "\n" + driver.getCurrentUrl() + "\n");
	}

}
