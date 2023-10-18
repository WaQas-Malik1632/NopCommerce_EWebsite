package Pages_Package;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public String Url = "https://demo.nopcommerce.com/";

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	LocalDateTime date = LocalDateTime.now();

	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH-mm-ss");
	String formattedDate = date.format(myFormatObj);

	public WebDriver Setup_Browser() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();

		return driver;
	}

	public WebDriver Setup_HeadlessBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("-incognito");
		options.addArguments("disable-popup-blocking");
		options.addArguments("--headless", "--window-size=1920,1200", "--ignore-certificate-errors");

		WebDriver driver = new ChromeDriver(options);
		driver.get(Url);
		driver.manage().window().maximize();

		return driver;
	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	@Parameters("browser")
	@BeforeTest
	public WebDriver SetupCrossBrowser(@Optional("defaultBrowser") String browser) {
		if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(Url);

		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(Url);
		} else if (browser.equalsIgnoreCase("Opera")) {
			WebDriverManager.operadriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(Url);
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(Url);
		}
		return driver;
	}
	*/

	// Take Screenshot
	public WebDriver TakeScreenshot(WebDriver webdriver, String filename) throws IOException {
		TakesScreenshot src = ((TakesScreenshot) webdriver);
		File srcfile = src.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(".//Screenshot//" + formattedDate + filename + ".png"));
		return webdriver;
	}
	
}
