package com.axa.testscripts;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.axa.base.TestBase;
import com.axa.properties.ConfigProperties;
import com.relevantcodes.extentreports.ExtentTest;

public class VerifyPolicySnapshat extends TestBase{
	private static ConfigProperties appProperties = ConfigProperties.getInstance();
	public static VerifyPolicySnapshat keyword = new VerifyPolicySnapshat();
  @Test
  public void verifyPolicySnapshotoncase() throws InterruptedException, AWTException {
	  
	  ExtentTest test = extent.startTest("User Story :172174 ", "Verify the Policy Snapshot related list on case page");
		
		 String username=appProperties.getProperty("Username");
		 String password=appProperties.getProperty("Password");
	
				
		 //login as AXA user
			CommonActions.AXALogin(test, driver, username, password);
			CommonActions.policysnapshot(test, driver);
			CommonActions.AXALogOut(driver, test);
			extent.endTest(test);
  }
  @BeforeClass
  public void beforeClass() {
	  initializeDriver();
	
  }

  @AfterClass
  public void afterClass() {
	  extent.flush();
  }
}
