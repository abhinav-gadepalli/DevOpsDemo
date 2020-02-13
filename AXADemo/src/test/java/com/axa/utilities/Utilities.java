package com.axa.utilities;

/*import gvjava.org.json.JSONArray;
import gvjava.org.json.JSONException;
import gvjava.org.json.JSONObject;*/

import java.awt.AWTException;
import java.awt.Robot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.axa.base.TestBase;
import com.axa.testscripts.ObjectRepository;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


/*
 * @Team AXA
 * 
 * This Class  contains reusable Wait functions and  functions to get Current date, month, year which can be used for entire project where ever required
 * */
public class Utilities extends TestBase {

	private static final Logger logger = Logger.getLogger(Utilities.class);
/*
 * 
 * This Function  Wait for elements present by xpath it accepts two @parameters driver, Xpath- String type and waits till element is visible 
 * */
	
	public static void WaitForElementPresentByXpath(WebDriver driver, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	/*
	 * 
	 * This Function  Wait for elements present by csspath it accepts two @parameters driver, csspath- String type and waits till element is visible 
	 * */
	public static void WaitForElementPresentBycsspath(WebDriver driver, String csspath) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(csspath)));
	}
	/*
	 * 
	 * This Function  Wait for elements present by id it accepts two @parameters driver, id- String type and waits till element is visible 
	 * */
	public static void WaitForElementPresentByid(WebDriver driver, String id) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	/*
	 * 
	 * This Function  Wait for elements present by BY type it accepts two @parameters driver, By- String type and waits till element is visible 
	 * */
	public static void WaitForElementPresentByid(WebDriver driver,By string) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(string));
		// TODO Auto-generated method stub
		
	}
	
	
	public static void WaitForElementPresentByxpath(WebDriver driver,By string) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(string));
		// TODO Auto-generated method stub
		
	}
	/*
	 * 
	 * This Function  Wait for elements present by  name type it accepts two @parameters driver, name- String type and waits till element is visible 
	 * */

	public static void WaitForElementPresentByname(WebDriver driver, String name) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
	}
	/*
	 * 
	 * This Function  Wait for elements present by  link text type it accepts two @parameters driver, linkText- String type and waits till element is visible 
	 * */
	public static void WaitForElementPresentBylinkText(WebDriver driver, String linkText) {
		WebDriverWait wait = new WebDriverWait(driver, 80);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
	}
	
	public static void WaitForElementPresentByLinkText(WebDriver driver, By linkText) {
		WebDriverWait wait = new WebDriverWait(driver, 80);

		wait.until(ExpectedConditions.visibilityOfElementLocated(linkText));
	}
	/*
	 * 
	 * This Function  Wait for elements present by  partialLinkText type it accepts two @parameters driver, partialLinkText- String type and waits till element is visible 
	 * */

	public static void WaitForElementPresentByPartiallinkText(WebDriver driver, String linkText) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(linkText)));
	}
	/*
	 * 
	 * This Function  Wait for elements present by  tagName type it accepts two @parameters driver, tagName- String type and waits till element is visible 
	 * */
	public static void WaitForElementPresentBytagName(WebDriver driver, String tagName) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
	}
	/*
	 * 
	 * This Function  Wait for elements present by  className type it accepts two @parameters driver, className- String type and waits till element is visible 
	 * */
	public static void WaitForElementPresentclassName(WebDriver driver, String className) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
	}
	/*
	 * 
	 * This Function check for element is present by  string  type it accepts two @parameters driver, By- String type and waits till element is visible  and returns boolean-true/false
	 * */

	public static boolean isElementPresent(WebDriver driver, ExtentTest test, By string) {
		try {
			driver.findElement(string);
			logger.info("Element "+string+ " is present");
		System.out.println("Element present"+string);
			return true;
		} catch (NoSuchElementException e) {
			logger.error("Error finding Element " + e.getMessage());
			String msg = e.getMessage();	
			test.log(LogStatus.FAIL, msg );
			return false;
		}
	}
	
	/*
	 * 
	 * This Function check for element is present by  locator  type it accepts two @parameters driver, By- By type and waits till element is visible  and returns String-Element Present/Element not Present
	 * */
	public static String ElementPresent(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);			
			return "Element Present";
		} catch (NoSuchElementException e) {			
			return "Element not Present";
		}
	}
	/**
	 * This Function check for element is present by  string  type it accepts three @parameters driver, S1 & S2- String type and throw a message for element presence/absence
	 * @param driver
	 * @param S1
	 * @param S2
	 */
	
	public static void ElementVerification(WebDriver driver,String S1, String S2){
	if(S1.equalsIgnoreCase(S2))
		{
			System.out.println("present");
		}
		else{
			System.out.println("not present");
		}
	}
	
	
	public static void clickfunction(WebDriver driver, By string){
		try {
			driver.findElement(string).click();
			logger.info("Element is  present");
			return ;
		} catch (NoSuchElementException e) {
			logger.error("Error finding Element " + e.getMessage());
			return ;
		}
	}
	
	/**
	 * This Function for open a new tab on clicking a link,it accepts two @parameters driver, string
	 * @param driver
	 * @param String 
	 */
	
	public static void openNewWindow(WebDriver driver, By string) throws InterruptedException{
	 driver.findElement(string).click();
        Thread.sleep(2000);	
        for(String TabWinHandle : driver.getWindowHandles()){
		driver.switchTo().window(TabWinHandle);
		}
		Thread.sleep(5000);
	}
	
	/**
	 * This Function for to close a new tab window it accepts two @parameters driver, string
	 * @param driver
	 * @param parenthandle 
	 */
	
	public static void closeWindow(WebDriver driver, String parenthandle) throws InterruptedException{
		 driver.close();
			driver.switchTo().window(parenthandle);
		}
	

	/**
	 * This Function check for element is present by  By type it accepts two @parameters driver, By-  type and waits till element is visible  and returns boolean-true/false
	 * @param driver
	 * @param by
	 * @return
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	
	public static boolean isElementPresent1(WebDriver driver, By by) throws AWTException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			logger.error("Error finding Element " + e.getMessage());
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	/**
	 * 
	 * This function for pressing ARROW DOWN and then ENTER key
	 * 
	 */
	
	public static void robot() throws AWTException, InterruptedException{
		  Robot robo = new Robot();
		  Thread.sleep(2000);
		  robo.keyPress(java.awt.event.KeyEvent.VK_DOWN);
		  Thread.sleep(2000);
		  robo.keyRelease(java.awt.event.KeyEvent.VK_DOWN);
		  Thread.sleep(2000);
		  robo.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		  Thread.sleep(2000);
		  robo.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		  Thread.sleep(5000);
		 }
	/**
	 * 
	 * This Function  to select a current date from datepicker window 
	 */
	
	public static String GetCurrentTime(){
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		 //get current date time with Date()
		Date date = new Date();
		
		// Now format the date
		 String date1= dateformat.format(date);
	 		
		return date1;
	}
	/*
	 * 
	 * This Function  to select a due date from datepicker window 
	 * */
	
	public static void GetDate(WebDriver driver){
		
		WebElement datewidget=driver.findElement(By.id("ui-datepicker-div"));
		//clicking for next month
		driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
		List<WebElement> columns=datewidget.findElements(By.tagName("td"));
		for (WebElement cell: columns){
		
			if(cell.getText().equals(ObjectRepository.Duedate))
					{
						cell.findElement(By.linkText(ObjectRepository.Duedate)).click();
						break;
					}
		}
		
	}
	
	/*
	 * 
	 * This Function  to select a due date from datepicker window 
	 * */
	
	public static void GetpostTestdueDate(WebDriver driver){
		
		WebElement datewidget=driver.findElement(By.id("ui-datepicker-div"));
		//clicking for next month
		driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
		List<WebElement> columns=datewidget.findElements(By.tagName("td"));
		for (WebElement cell: columns){
		
			if(cell.getText().equals(ObjectRepository.PostTestDuedate))
					{
						cell.findElement(By.linkText(ObjectRepository.PostTestDuedate)).click();
						break;
					}
		}
		
	}
	
	/*
	 * 
	 * This Function  gets Current Day from calender and returns day of Integer type
	 * */
	public static int GetCurrentDay(){
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	/**
	 * 
	 * This Function  gets Current monthfrom calender and returns month of Integer type
	 **/
	
	public static int GetCurrentMonth() {
		int month = Calendar.getInstance().get(Calendar.MONTH);
		logger.info("Month=" + month);
		return month;

	}
	
	/**
	 * 
	 *This function gives the mouse hover functionality
	 */
	
	public static void mousehover(By by){
		WebElement help= driver.findElement(by);
		Actions ac = new Actions(driver);
		ac.moveToElement(help).build().perform();
	}
	
	/**
	 * 
	 * This Function  gets Current monthName from calender and returns monthName of String  type
	 * */

	public static String GetCurrentMonthName() {
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		Calendar cal = Calendar.getInstance();
		String month = monthName[cal.get(Calendar.MONTH)];
		return month;
	}

	/**
	 * 
	 * This Function  gets Current Year from calender and returns Year of String  type
	 **/
	
	public static int GetCurrentYear() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		logger.info("Year=" + year);
		return year;
	}
	
	/*
	 * 
	 * This Function  checks if alert is present and handles if alert present it accepts one@parameter driver and returns boolean type-true/falls
	 * 
	 * */

	public static boolean isAlertPresent(WebDriver driver,ExtentTest test) {
		boolean presentFlag = false;
		try {
			/* Check the presence of alert */
			  WebDriverWait wait = new WebDriverWait(driver, 180);
		        wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			
			
			 String text=alert.getText();
			 test.log(LogStatus.INFO,"Alert Present","Alert is present and handled text on  alert is: "+ text);
			// Alert present; set the flag
			presentFlag = true;
			/* if present consume the alert */
			alert.accept();  
     	   logger.info("Alert is present and handled text on  alert is: "+ text);
		
		} catch (NoAlertPresentException ex) {
			/* Alert not present */
			test.log(LogStatus.INFO,"Alert not  Present","Alert is not present");
			logger.error("Error finding Alert " + ex.getMessage());
		}
		return presentFlag;
	}


	/**
	 * This Function verifies the actual result with expected  
	 * @param driver
	 * @param rownum
	 * @param xpath
	 */
	
	public static void textvalidation(WebDriver driver, int rownum, By xpath)
	{
		
		Object text = driver.findElement(xpath).getText();
		System.out.println(text);
		String savedtext = datatable.getCellData("Text","Texts" ,rownum);	
		System.out.println(savedtext);
		if(text.equals(savedtext)){
			System.out.println(savedtext+" and "+text+" validated Sucessfully");
		
		}else{
		System.out.println(savedtext+" and "+text+" validation failed");
		}
			
	}
	
	
	
	public static void selectInputDropDown(String label, String val){

	   //    ComLib.InputText(label,val);
	       By xpath1 = By.xpath(String.format("//div[contains(@class,'small')]//div[contains(@title,'%s') ]", val));
	       By xpath2 = By.xpath(String.format("//div[contains(@title,'%s')]", val));

	       ArrayList<By> al_inputText = new ArrayList<By>();
	       al_inputText.add(xpath1);
	       al_inputText.add(xpath2);

	       By ele = al_inputText.stream().filter(by->isElementPresent(driver, null, by)).findFirst().get();
	       findElement(ele).click();

	}
	private static WebElement findElement(By ele) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}
	
	
	
	
	
	
	

	
	
	

