package Pages_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {
	WebDriver driver;
	By click_register=By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
	By Gender_Male=By.id("gender-male");
	By Gender_Female=By.id("gender-female");
	By txt_firstname=By.id("FirstName");
	By txt_lastname=By.id("LastName");
	By txt_Email=By.id("Email");
	By txt_companyName=By.id("Company");
	By txt_password=By.id("Password");
	By txt_confirm_Password=By.id("ConfirmPassword");
	By btn_Register=By.id("register-button");
	
	public SignupPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void Precondition()
	{
		driver.findElement(click_register).click();
	}
	public void SignUp_Form(String Fname, String Lname, String Email, String CompanyName, String Pass, String ConfPass)
	{
	driver.findElement(By.id("gender")).click();
	WebElement RadiobuttonMale=driver.findElement(Gender_Male);
	RadiobuttonMale.click();
		
		//WebElement RadiobuttonFemale=driver.findElement(Gender_Female);
		//RadiobuttonFemale.click();	
		
		WebElement Firstname=driver.findElement(txt_firstname);
		Firstname.sendKeys(Fname);
		
		WebElement Lastname=driver.findElement(txt_lastname);
		Lastname.sendKeys(Lname);
		
		WebElement email=driver.findElement(txt_Email);
		email.sendKeys(Email);
		
		WebElement comp=driver.findElement(txt_companyName);
		comp.sendKeys(CompanyName);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window", 0,700);
		
		WebElement pass=driver.findElement(txt_password);
		pass.sendKeys(Pass);
		
		WebElement Confpass=driver.findElement(txt_confirm_Password);
		Confpass.sendKeys(ConfPass);
		
		WebElement btnReg=driver.findElement(btn_Register);
		btnReg.click();
		//btnReg.getText();
	

		//After signup click on continue button to go to home page
		WebElement click_ContinueReg=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a"));
		click_ContinueReg.click();
	}


}