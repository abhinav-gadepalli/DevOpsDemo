package com.axa.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.axa.base.TestBase;
import com.axa.properties.ConfigProperties;
import com.relevantcodes.extentreports.ExtentTest;


public class PatientEnrollmentTest extends TestBase {
	
	private static ConfigProperties appProperties = ConfigProperties.getInstance();
  @Test
  public void f() {
	  try {
			 ExtentTest test = extent.startTest("Patient Enrollment Test ", " This test verifies patient enrollment status");
			
			 String username=appProperties.getProperty("Username");
			 String password=appProperties.getProperty("Password");
		
					
			 //login as AXA user
				CommonActions.AXALogin(test, driver, username, password);
				CommonActions.patientenroll(test, driver);
				
				extent.endTest(test);
			

					
		} catch (Exception e) {
			// TODO: handle exception
		}
}
@BeforeClass
public void beforeClass() {
	  initializeDriver();
	
}

@AfterClass
public void afterClass() {
}

}
