package com.eCommerce.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import com.eCommerce.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();

	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setup() {
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "msedge":
			driver = new EdgeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

		// implicit wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// for logging
		logger = LogManager.getLogger("eCommerceProjectV2");
		//open url
				driver.get(url);
				logger.info("url opened");
				
		

	}
//	@AfterClass 
//	public void tearDown()
//	{
//		driver.close();
//		driver.quit();

//	}
	public void captureScreenShot(WebDriver driver, String testName) throws IOException {
		// step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		// step2: call getScreenshotAs method to create image file

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

		// step3: copy image file to destination
		FileUtils.copyFile(src, dest);
	}

}
