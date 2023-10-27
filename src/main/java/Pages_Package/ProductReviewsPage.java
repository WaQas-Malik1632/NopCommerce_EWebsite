package Pages_Package;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class ProductReviewsPage {

	private WebDriver driver;

	By Computers = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']");
	By Desktop = By.xpath("//img[@title='Show products in category Desktops']");
	By Custom_Desktop = By.xpath("//div[@class='picture']//img[@title='Show details for Build your own computer']");
	By AddCart = By.xpath("//button[@id='add-to-cart-button-1']");

	By CheckItemsCart = By.xpath("//span[@class='cart-label']");

	By errorForRAM = By.xpath("//p[normalize-space()='Please select RAM']");
	By errorForHDD = By.xpath("//p[normalize-space()='Please select HDD']");

	By SuccessMSGItemAddToCart = By.xpath("//a[normalize-space()='shopping cart']");

	By Radio_32GBHDD = By.xpath("//label[@for='product_attribute_3_6']");
	By Radio_400GBHDD = By.xpath("//label[@for='product_attribute_3_7']");

	By AddReviewClick = By.xpath("//a[normalize-space()='Add your review']");
	By ReviewTitle = By.xpath("//input[@id='AddProductReview_Title']");
	By ReviewMessage = By.xpath("//textarea[@id='AddProductReview_ReviewText']");
	By Rating1 = By.xpath("//input[@id='addproductrating_1']");
	By Rating2 = By.xpath("//input[@id='addproductrating_2']");
	By Rating3 = By.xpath("//input[@id='addproductrating_3']");
	By Rating4 = By.xpath("//input[@id='addproductrating_4']");
	By Rating5 = By.xpath("//input[@id='addproductrating_5']");
	By SubmitReview = By.xpath("//button[@name='add-review']");

	public ProductReviewsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void CustomDesktopOrder() {

		Actions action = new Actions(driver);
		WebElement ComputersMenu = driver.findElement(Computers);
		action.moveToElement(ComputersMenu).click().perform();

		driver.manage().timeouts().pageLoadTimeout(03, TimeUnit.SECONDS);
		WebElement Desktops = driver.findElement(Desktop);
		Desktops.click();

		WebElement DesktopItemClick = driver.findElement(Custom_Desktop);
		DesktopItemClick.click();

//		WebElement AddCartbtn = driver.findElement(AddCart);
//		AddCartbtn.click();

		// Select RAM for his own choice
		Select RAM_Dropdown = new Select(driver.findElement(By.id("product_attribute_2")));
//		RAM_Dropdown.selectByVisibleText("4GB [+$20.00]");
		RAM_Dropdown.selectByVisibleText("8GB [+$60.00]");
//		RAM_Dropdown.getAllSelectedOptions();
		RAM_Dropdown.getFirstSelectedOption();
		System.out.println("Selected option is: " + RAM_Dropdown);

		// Select HDD for his own choice
//		WebElement RAM32GB = driver.findElement(Radio_32GBHDD);
//		RAM32GB.click();
//		System.out.println("Selected option is: " + RAM32GB);

		WebElement RAM400GB = driver.findElement(Radio_400GBHDD);
		RAM400GB.click();

		WebElement AddCartbtn = driver.findElement(AddCart);
		AddCartbtn.click();

		// WebElement CartClick=driver.findElement(CheckItemsCart);
		// CartClick.click();

	}

	public void AddReviewsOfDesktop(String RvwTitle, String RvwMsg) throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement ComputersMenu = driver.findElement(Computers);
		action.moveToElement(ComputersMenu).click().perform();

		driver.manage().timeouts().pageLoadTimeout(03, TimeUnit.SECONDS);
		WebElement Desktops = driver.findElement(Desktop);
		Desktops.click();

		WebElement DesktopItemClick = driver.findElement(Custom_Desktop);
		DesktopItemClick.click();

		try {
			WebElement AddreviewClick = driver.findElement(By.xpath("//a[normalize-space()='Add your review']"));
			AddreviewClick.click();

		} catch (Exception e) {
			System.out.println("Add Review button element is not found.");
			throw (e);
		}
		System.out.println("Add Review button element found.");

		WebElement reviewTitle = driver.findElement(ReviewTitle);
		reviewTitle.sendKeys(RvwTitle);

		WebElement reviewMessage = driver.findElement(ReviewMessage);
		reviewMessage.sendKeys(RvwMsg);

		WebElement Ratings = driver.findElement(Rating4);
		Ratings.click();

		// WebElement ReviewSubmit = driver.findElement(SubmitReview);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		WebElement ReviewSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(SubmitReview));
		ReviewSubmit.click();

	}

}
