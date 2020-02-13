package com.axa.testscripts;

import java.awt.AWTException;
import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.axa.base.TestBase;
import com.axa.properties.ConfigProperties;
import com.axa.testscripts.CommonActions;
import com.axa.utilities.Utilities;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
/**
 * This is a static  class it contains  all reusable  verify  methods 
 * 
 * @author AXA Automation Team USI
 *
 */
public class CommonActions extends  TestBase{
	

	private static ConfigProperties appProperties = ConfigProperties.getInstance();
	public static String txtfile=System.getProperty("user.dir") +File.separator + "src\test\resources" + File.separator+"AXA.docx";
	public static String pdffile=System.getProperty("user.dir") +File.separator + "src\test\resources" + File.separator+"forms.pdf";

	
	public static  CommonActions keyword = new CommonActions();

	private static final Logger logger = Logger.getLogger(AXA_PartnerSelection_Test.class);
	
	
	/* This function Validates login function with Valid UserName and Password */
	public static void AXALogin(ExtentTest test, WebDriver driver, String username, String password ) throws InterruptedException{
		
		try {
			
	
            test.log(LogStatus.INFO,"Get URL","Get the Url from Resources");	
			String Url = appProperties.getProperty( "baseUrl" );		
			driver.get(Url);	
			test.log(LogStatus.INFO,"Waiting for Url to Load"," Entered URL :" +Url);
			test.log(LogStatus.INFO,"Log into AXA application", "Logging using user name and password");
		
			/* user name */
			driver.findElement(ObjectRepository.username).clear();
			Thread.sleep(1000);
			driver.findElement(ObjectRepository.username).sendKeys(username);
			test.log(LogStatus.INFO,"Enter UserName", " Entered User Name: "+username);
			Thread.sleep(1000);
			
			//give password
			Utilities.WaitForElementPresentByid(driver,  ObjectRepository.password);
			test.log(LogStatus.INFO,"Enter Password", " Entered Password: "+ "*******");
			driver.findElement(ObjectRepository.password).clear();
			Thread.sleep(2000);
			driver.findElement(ObjectRepository.password).sendKeys(password);
			Thread.sleep(1000);
			//click on login button
				
			driver.findElement(ObjectRepository.login_button).click();
			test.log(LogStatus.INFO,"click Login Button", "Clicked on Login Button");
			test.log(LogStatus.INFO,"Wait for Page to load","waiting for login page to be load");
			test.log(LogStatus.INFO,"Login Success","Logged In Successfully");
			Thread.sleep(5000);
			
			} catch (NoSuchElementException e) {
				test.log(LogStatus.INFO,"Login page - Exception ","Login page - No Such Element in current page");
				// TODO Auto-generated catch block
				String screenshot = System.getProperty("user.dir") +File.separator + "screenshot" + File.separator+"Login.jpg";
				screenCapture(screenshot);
				e.printStackTrace();
    			String msg = e.getMessage();	
    			test.log(LogStatus.FAIL, msg );
			}
	 }
	
	
public static void patientenroll(ExtentTest test, WebDriver driver ) throws InterruptedException{
		
		try {
			Thread.sleep(2000);
			driver.findElement(ObjectRepository.patient_enroll_form).click();
			test.log(LogStatus.INFO, "Click on patient enrollment form", "Clicked on patient enrollment form");
			Thread.sleep(5000);
			 driver.findElement(ObjectRepository.patient_firstname).clear();
			 String name="Sandeep";
			 driver.findElement(ObjectRepository.patient_firstname).sendKeys(name);
			 test.log(LogStatus.INFO, "Enter Patient name", "Entered patient name : "+name);
			 driver.findElement(ObjectRepository.enroll_button).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.INFO, "Click on enroll button", "Clicked on enroll button");
			String status= driver.findElement(ObjectRepository.get_status).getText();
			test.log(LogStatus.INFO, "Get status", "Status of acitivity : "+status);
			 
			Thread.sleep(5000);
			
			} catch (NoSuchElementException e) {
				test.log(LogStatus.INFO,"Login page - Exception ","patient  enroll - No Such Element in current page");
				// TODO Auto-generated catch block
				String screenshot = System.getProperty("user.dir") +File.separator + "screenshot" + File.separator+"patientenroll.jpg";
				screenCapture(screenshot);
				e.printStackTrace();
    			String msg = e.getMessage();	
    			test.log(LogStatus.FAIL, msg );
			}
	 }
	
public static void AXAPartnerSelection(ExtentTest test, WebDriver driver ) throws InterruptedException{
		
		try {
			Utilities.WaitForElementPresentByid(driver, ObjectRepository.AXA_Assistance_icon);
			driver.findElement(ObjectRepository.AXA_Assistance_icon).click();
			Thread.sleep(2000);
			test.log(LogStatus.INFO,"click on AXA App Launcher", "clicked on AXA App Launcher");
			String ws="waiting screen";
			driver.findElement(ObjectRepository.search_app).sendKeys(ws);
			Thread.sleep(2000);
			
			driver.findElement(ObjectRepository.waiting_screen).click();
			test.log(LogStatus.INFO,"click on Waiting screen", "Clicked on Waiting screen");
			
			Thread.sleep(2000);
			
			test.log(LogStatus.INFO,"click on Partner dropdown", "Clicked on partner dropdown");
			driver.findElement(ObjectRepository.Partner_picklist).click();
			Thread.sleep(2000);	
			driver.findElement(ObjectRepository.AXA_Partner).click();
			Thread.sleep(2000);	
			test.log(LogStatus.INFO,"Select Partner from Picklist", "Selected partner ");
			driver.findElement(ObjectRepository.Motor_tab).click();
			Thread.sleep(1000);	
			
			test.log(LogStatus.INFO,"Click on Motor", "Clicked on Motor");
			
		boolean accident=driver.findElement(ObjectRepository.Accident).isDisplayed();
		if(accident==true){
			test.log(LogStatus.PASS,"Type of Incident Accident Displayed"," "+accident);
		}else{
			test.log(LogStatus.FAIL,"Type of Incident Accident Displayed"," "+accident);
		}

		boolean breakdown=	driver.findElement(ObjectRepository.Breakdown).isDisplayed();
		if(breakdown==true){
			test.log(LogStatus.PASS,"Type of Incident Breakdown Displayed"," "+breakdown);
		}else{
			test.log(LogStatus.FAIL,"Type of Incident Breakdown Displayed"," "+breakdown);
		}
		boolean rfi=	driver.findElement(ObjectRepository.RFI).isDisplayed();
		if(rfi==true){
			test.log(LogStatus.PASS,"Type of Incident RFI Displayed"," "+rfi);
		}else{
			test.log(LogStatus.FAIL,"Type of Incident RFI Displayed"," "+rfi);
		}
		
		driver.findElement(ObjectRepository.Home_tab).click();
		test.log(LogStatus.INFO,"Click on Home", "Clicked on Home");
		Thread.sleep(1000);	
		boolean emergency=driver.findElement(ObjectRepository.Emergency).isDisplayed();
		if(emergency==true){
			test.log(LogStatus.PASS,"Type of Incident Emergency Displayed"," "+emergency);
		}else{
			test.log(LogStatus.FAIL,"Type of Incident Emergency Displayed"," "+emergency);
		}
		boolean planned=driver.findElement(ObjectRepository.Planned).isDisplayed();
		if(planned==true){
			test.log(LogStatus.PASS,"Type of Incident planned Displayed"," "+planned);
		}else{
			test.log(LogStatus.FAIL,"Type of Incident planned Displayed"," "+planned);
		}
		boolean rfi_home=	driver.findElement(ObjectRepository.RFI).isDisplayed();
		if(rfi_home==true){
			test.log(LogStatus.PASS,"Type of Incident RFI Displayed"," "+rfi_home);
		}else{
			test.log(LogStatus.FAIL,"Type of Incident RFI Displayed"," "+rfi_home);
		}
		driver.findElement(ObjectRepository.Motor_tab).click();
		Thread.sleep(1000);	
		//String Firstname = "Norman";
		driver.findElement(ObjectRepository.firstname_textbox).clear();
		Thread.sleep(1000);	
		//driver.findElement(OR.firstname_textbox).sendKeys(Firstname);
		driver.findElement(ObjectRepository.lastname_textbox).sendKeys("v");
		test.log(LogStatus.INFO,"Search for policy using last name ", "Entered last name : "+ " v");
		driver.findElement(ObjectRepository.quickSearch_button).click();
		Thread.sleep(2000);
	    /*driver.findElement(OR.security_identity_checkbox).click();
		test.log(LogStatus.INFO, "Verify Security Identity Check", "Verified Security Identity Check");
		Thread.sleep(2000);*/
		
		driver.findElement(ObjectRepository.create_case_button).click();
		test.log(LogStatus.INFO, "Click on Create case Button", "Clicked on Create case button");
		String alertmessage =driver.switchTo().alert().getText();
		test.log(LogStatus.INFO, "Alert Message :", ""+alertmessage);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Click on Ok button", "Clicked on Ok button");
		/*driver.findElement(OR.security_identity_checkbox).click();
		test.log(LogStatus.INFO, "Verify  Security Identity Check", "Verified Security Identity Check");
		Thread.sleep(2000);	
		String alertmessage2 =driver.switchTo().alert().getText();
		test.log(LogStatus.INFO, "Alert Message :", ""+alertmessage2);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Click on Ok button", "Clicked on Ok button");
		String alertmessage3 =driver.switchTo().alert().getText();
		test.log(LogStatus.INFO, "Alert Message :", ""+alertmessage3);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Click on Ok button", "Clicked on Ok button");*/
		
			
			} catch (NoSuchElementException e) {
				test.log(LogStatus.FAIL,"Partner Selection- Exception ","Partner Selection page - No Such Element in current page");
				// TODO Auto-generated catch block
				String screenshot = System.getProperty("user.dir") +File.separator + "screenshot" + File.separator+"Partner_selection.jpg";
				screenCapture(screenshot);
				e.printStackTrace();
    			String msg = e.getMessage();	
    			test.log(LogStatus.FAIL, msg );
			}
	 }
	
	

	
	/*
	 * This function Validates logout function it accepts two @parameters driver and test
	 * */
	
	public static void AXALogOut(WebDriver driver, ExtentTest test) throws AWTException, InterruptedException {
		
		try{
			Thread.sleep(10000);
			driver.findElement(ObjectRepository.logout_icon).click();
			test.log(LogStatus.INFO,"click Logout image icon ", "Clicked on Logout image icon");
			Thread.sleep(1000);
			driver.findElement(ObjectRepository.logout_button).click();
			test.log(LogStatus.INFO,"click Login Button", "Clicked on Login Button");
		} catch (NoSuchElementException e) {
			test.log(LogStatus.FAIL,"Logout page - Exception ","Logout page - No Such Element in current page");
			// TODO Auto-generated catch block
			String screenshot = System.getProperty("user.dir") +File.separator + "screenshot" + File.separator+"logOut.jpg";
			screenCapture(screenshot);
			e.printStackTrace();
			String msg = e.getMessage();	
			test.log(LogStatus.FAIL, msg );
		} 
	}
	
	
	
public static void policysnapshot(ExtentTest test, WebDriver driver ) throws InterruptedException{
		
		try {
			
			driver.findElement(ObjectRepository.cases).click();
			Thread.sleep(1000);
			test.log(LogStatus.INFO, "Click on Cases", "Clicked on cases tab");
			String casenumber = "00054955";
			driver.findElement(ObjectRepository.case_Search_bar).sendKeys(casenumber);
			Thread.sleep(1000);
			test.log(LogStatus.INFO, "Search for an existing case", "Searching for an existing case : "+ casenumber);
			driver.findElement(ObjectRepository.case_Search_bar).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			
			
	
           
			
			} catch (NoSuchElementException e) {
				
				// TODO Auto-generated catch block
				String screenshot = System.getProperty("user.dir") +File.separator + "screenshot" + File.separator+"Case_Emergency_motor.jpg";
				screenCapture(screenshot);
				e.printStackTrace();
    			String msg = e.getMessage();	
    			test.log(LogStatus.FAIL, msg );
			}
	 }
		 

public static void AXAOptin_Verify(ExtentTest test, WebDriver driver ) throws InterruptedException{
    
    try {

          //long timeoutInSeconds = 0;
          //WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/")));
          
          
          driver.findElement(ObjectRepository.CMS_Con).click();
          Thread.sleep(5000);
          
          driver.findElement(ObjectRepository.Con_New).click();
          Thread.sleep(5000);
          test.log(LogStatus.INFO,"click on New", "Clicked on new contact");
          driver.findElement(ObjectRepository.Con_Next).click();
          Thread.sleep(2000);
          System.out.println("ujdfadis");
          test.log(LogStatus.INFO,"Enter Lastname", "Entered lastname");
           driver.findElement(ObjectRepository.Con_LastName).sendKeys("John");
          test.log(LogStatus.INFO,"Select Record type and click on next", "Selected record type and clicked on next");
          boolean nosurvey=driver.findElement(ObjectRepository.Con_NoSurvey).isDisplayed();       
          if(nosurvey==true)
          {
                 test.log(LogStatus.INFO,"Verify No survey field exists", "No survey field should be available"+nosurvey);
                 driver.findElement(ObjectRepository.Con_Save).click();
                 test.log(LogStatus.INFO,"Click on Save to save the contact", "Saved the contact");
                 Thread.sleep(3000);
                 WebElement element = driver.findElement(ObjectRepository.Con_Details);
                 Actions actions= new Actions(driver);
//               actions.doubleClick(element).build().perform();
                 driver.findElement(ObjectRepository.Con_Details).click();             
                 Thread.sleep(3000);
                 test.log(LogStatus.INFO,"Navigate to Details screen", "Navigated to Details screen");
                 driver.findElement(ObjectRepository.Con_NoSurvey).isDisplayed();
                 Thread.sleep(3000);
                 test.log(LogStatus.INFO,"Verify Nosurvey field is avalable on layout", "No survey field should be available");
                 WebElement element1 =driver.findElement(ObjectRepository.Con_NSedit); 
                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 js.executeScript("window.scrollBy(0, 250)", "");
            //js.executeScript("arguments[0].scrollIntoView();",element1);
                 actions.doubleClick(element1).build().perform();
                 test.log(LogStatus.INFO,"click on Edit", "clicked on Edit");
                 Thread.sleep(2000);
                 boolean checked =driver.findElement(ObjectRepository.Con_NSchkbox_editmode).isSelected();
                 Thread.sleep(2000);
                 System.out.println("checked");
                 test.log(LogStatus.INFO,"Verify Nosurvey field is checked on contact creation", "No survey field is checked on contact creation"+checked);
                 //driver.findElement(OR.Con_NSedit).click();
                       //Thread.sleep(1000);
//               WebElement element2= driver.findElement(OR.Con_NScheckbox);
//               actions.moveToElement(element2).perform();
//               actions.click(element2).build().perform();
                 driver.findElement(ObjectRepository.Con_NSedit).click();
                       Thread.sleep(2000);
                        driver.findElement(ObjectRepository.Con_Save).click();
                       Thread.sleep(2000);
                                           
          }      
          else
          {
                 
                 test.log(LogStatus.INFO,"Verify No survey field exists", "No survey field is not available"+nosurvey);
         
          }
          
          
          } catch (NoSuchElementException e) {
                 
                 // TODO Auto-generated catch block
                 String screenshot = System.getProperty("user.dir") +File.separator + "screenshot" + File.separator+"Optin.jpg";
                 screenCapture(screenshot);
                 e.printStackTrace();
                 String msg = e.getMessage();     
                 test.log(LogStatus.FAIL, msg );
          }
}


 	 	 	
 	}
 	
 	
 	
 	
 	
 	
   

				

    	
 	

	  

	
     

