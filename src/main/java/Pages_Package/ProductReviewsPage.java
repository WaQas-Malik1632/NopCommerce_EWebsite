package Pages_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductReviewsPage {
	
	WebDriver driver;
	
	By Computers = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']");
	By Desktop = By.xpath("//img[@title='Show products in category Desktops']");
	By DesktopShoppingCart = By.xpath("//a[normalize-space()='shopping cart']");
	
	By AddReviewClick=By.xpath("//a[normalize-space()='Add your review']");
	By ReviewTitle=By.xpath("//input[@id='AddProductReview_Title']");
	By ReviewMessage=By.xpath("//textarea[@id='AddProductReview_ReviewText']");
	By Rating1=By.xpath("//input[@id='addproductrating_1']");
	By Rating2=By.xpath("//input[@id='addproductrating_2']");
	By Rating3=By.xpath("//input[@id='addproductrating_3']");
	By Rating4=By.xpath("//input[@id='addproductrating_4']");
	By Rating5=By.xpath("//input[@id='addproductrating_5']");
	By SubmitReview=By.xpath("//button[@name='add-review']");
	
	public ProductReviewsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void AddReviewsOfDesktop(String RvwTitle, String RvwMsg) throws InterruptedException
	{
		Actions action = new Actions(driver);
		WebElement ComputersMenu=driver.findElement(Computers);
		action.moveToElement(ComputersMenu).click().perform();
		
		Thread.sleep(2000);
		WebElement Desktops=driver.findElement(Desktop);
		Desktops.click();
		
		Thread.sleep(2000);
		WebElement DesktopName=driver.findElement(DesktopShoppingCart);
		DesktopName.click();
		
		WebElement AddreviewClick=driver.findElement(By.xpath("//a[normalize-space()='Add your review']"));
		AddreviewClick.click();
		
		WebElement reviewTitle=driver.findElement(ReviewTitle);
		reviewTitle.sendKeys(RvwTitle);
		
		WebElement reviewMessage=driver.findElement(ReviewMessage);
		reviewMessage.sendKeys(RvwMsg);
		
		WebElement Ratings=driver.findElement(Rating4);
		Ratings.click();
		
		WebElement ReviewSubmit=driver.findElement(SubmitReview);
		ReviewSubmit.click();
		
	
	}

}
