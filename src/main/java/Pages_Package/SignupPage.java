package Pages_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
	private WebDriver driver;
	private JavascriptExecutor js = (JavascriptExecutor) driver;

	By click_register = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
	By Gender_Male = By.id("gender-male");
	By Gender_Female = By.id("gender-female");
	By txt_firstname = By.id("FirstName");
	By txt_lastname = By.id("LastName");
	By txt_Email = By.id("Email");
	By txt_companyName = By.id("Company");
	By txt_password = By.id("Password");
	By txt_confirm_Password = By.id("ConfirmPassword");
	By btn_Register = By.id("register-button");

	public SignupPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Precondition() {
		driver.findElement(click_register).click();
	}

	public boolean SignUp_Form(String Fname, String Lname, String Email, String CompanyName, String Pass,
			String ConfPassword) {
		driver.findElement(By.id("gender")).click();
		WebElement RadiobuttonMale = driver.findElement(Gender_Male);
		RadiobuttonMale.click();

		// WebElement RadiobuttonFemale=driver.findElement(Gender_Female);
		// RadiobuttonFemale.click();

		WebElement Firstname = driver.findElement(txt_firstname);
		Firstname.sendKeys(Fname);

		WebElement Lastname = driver.findElement(txt_lastname);
		Lastname.sendKeys(Lname);

		// Select Date of Birthday
		// Select Day
		Select Day_Dropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		Day_Dropdown.selectByVisibleText("10");
		System.out.println("Selected option is: " + Day_Dropdown);

		// Select Month
		Select Month_Dropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		Month_Dropdown.selectByVisibleText("March");
		System.out.println("Selected option is: " + Month_Dropdown);

		// Select Year
		Select Year_Dropdown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		Year_Dropdown.selectByVisibleText("2014");
		System.out.println("Selected option is: " + Year_Dropdown);

		WebElement email = driver.findElement(txt_Email);
		email.sendKeys(Email);

		WebElement comp = driver.findElement(txt_companyName);
		comp.sendKeys(CompanyName);

		// Scrolling down the page till the element is found
		// js.executeScript("arguments[0].scrollIntoView();", comp);

		WebElement pass = driver.findElement(txt_password);
		pass.sendKeys(Pass);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window", 0, 700);

		WebElement Confpass = driver.findElement(txt_confirm_Password);
		Confpass.sendKeys(ConfPassword);

//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnReg);

		WebElement btnReg = driver.findElement(btn_Register);
		btnReg.click();

		// btnReg.getText();

		// After signup click on continue button to go to home page
		WebElement click_ContinueReg = driver
				.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a"));
		click_ContinueReg.click();
		// a[@class='ico-register']

		return true;
	}

}
