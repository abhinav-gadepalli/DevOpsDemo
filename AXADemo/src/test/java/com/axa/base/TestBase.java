package com.axa.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.axa.properties.ConfigProperties;
import com.axa.properties.ExtentManager;
import com.axa.utilities.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;

/**
 * This class invokes all the required resources that were used in script 
 * @author Team AXA
 *
 */
public class TestBase {

	private static final Logger logger = Logger.getLogger(TestBase.class);

	public static WebDriver driver = null;
	public static AXAWebDriver AXADriver = null;

	public static ConfigProperties configProperties = null;
	public static Boolean isInitialized = false;
	public static boolean isSkip = false;
	public static boolean isFail = false;
	public static boolean isPass = false;
	public static int count = -1;
	public static int rownum = -1;

	public static ExcelReader suite = null;
	public static ExcelReader temp2 = null;
	public static ExcelReader datatable = null;
	
	public static Method method[] = null;
	
	public static ExtentReports extent = null;

	public static Object data[][] = null;
	
	
	static {
		initialize();
	}
	
	/**
	 *Get Instance of ConfigProperties and  Reading data from config.properties text file and Read Test data From external sources
	 *
	 */
	
	@BeforeSuite
	public static void initializeSuite() throws MalformedURLException {
	
		configProperties = ConfigProperties.getInstance();
		initializeDriver();
		openBrowser();
	}

	public static void initialize() {
		if (isInitialized == false) {
			try {
				extent = ExtentManager.getInstance();
								
				/* Reading TestData ExcelReader */
				logger.debug("Loading data for tests ...");
			
			datatable = new ExcelReader("./src/test/resources/AXATestDataSheet.xlsx");
			
				logger.debug("Complete loading data for tests ...");
				isInitialized = true;
			} catch ( Exception e ) {
				logger.error("Error reading test suite data " + e.getMessage());
			}
		}
	}
	/**
	 *Get property values of browserType and useGrid from config.properties
	 * @throws InterruptedException 
	 *
	 */
	public static void initializeDriver()  {
		String browserType = configProperties.getProperty("browserType");
		boolean useGrid = Boolean.parseBoolean(configProperties.getProperty("useGrid"));
		AXADriver = AXAWebDriver.getInstance(browserType, useGrid);
		driver =  AXADriver.getDriver();
		/*driver.get("chrome://settings/advanced");
		driver.findElement(By.id("privacyContentSettingsButton")).click();
		driver.findElement(By.name("popups")).click();*/
		driver.manage().window().maximize();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 *Open the required browser wait for Page to Load and Maximize browser window
	 */
	
	public static void openBrowser() {
		
		try {
			
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 *Close current window and close all the opened windows and release  driver
	 */
	public static void closeBrowser() {
		try {
			logger.info("Closing all opened browsers");
			driver.close();
			driver.quit();
			AXADriver.releaseDriver();
		} catch( Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	
	/**
	 *Close extent reports
	 *
	 */
	@AfterSuite
	public void afterSuite()
	{
		extent.flush();
		extent.close();
	}

	/**
	 *Capture Screen shot in case of script failure 
	 *
	 */
	public static void screenCapture(String path) {
		
		/*capturing Screen Shot */
		try {
			logger.info("Capturing screenshot at path " + path);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(path));
			logger.info("Captured screenshot at path " + path);
		} catch (IOException e) {
			logger.error("Error taking screen shot " + e.getMessage());
		}
	}
	
	@AfterSuite
	 public static void broswerClose(){
		 closeBrowser();
		}

}
