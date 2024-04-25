package Pages_Package;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;

	By click_login = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");
	By txt_email = By.id("Email");
	By txt_password = By.id("Password");
	By btn_login = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Precondition() {
		driver.findElement(click_login).click();

		driver.manage().timeouts().pageLoadTimeout(05, TimeUnit.SECONDS);
	}

	public boolean Login_Testcases(String Email, String Pass) {

		try {
			WebElement u1 = driver.findElement(txt_email);
			u1.sendKeys(Email);

		} catch (Exception e) {
			System.out.println("Email element is not found.");
			throw (e);
		}
		System.out.println("Email field found");

		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

		try {
			WebElement p1 = driver.findElement(txt_password);
			p1.sendKeys(Pass);

		} catch (Exception e) {
			System.out.println("Password element is not found.");
			throw (e);
		}
		System.out.println("Password field found");
/*
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(btn_login));
		*/
		// click on the login button as soon as the button is visible

		WebElement b1 = driver.findElement(btn_login);
		b1.click();

		// u1.getScreenshotAs(OutputType.FILE);

		String actualUrl = driver.getCurrentUrl();
		String expectrdUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";

		boolean cond = false;
		if (actualUrl.equalsIgnoreCase(expectrdUrl)) {
			cond = true;
			System.out.println(cond + "-> User logged in scccessfully");
		} else

			System.out.println(cond + "-> User didn't log into the system scccessfully");
		return cond;

	}
}
