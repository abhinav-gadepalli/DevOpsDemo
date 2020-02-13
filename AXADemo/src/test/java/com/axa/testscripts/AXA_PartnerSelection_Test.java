package com.axa.testscripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.axa.base.TestBase;
import com.axa.properties.ConfigProperties;
import com.relevantcodes.extentreports.ExtentTest;

public class AXA_PartnerSelection_Test extends TestBase{
	private static final Logger logger = Logger.getLogger(AXA_PartnerSelection_Test.class);
	public static AXA_PartnerSelection_Test keyword = new AXA_PartnerSelection_Test();
	private static ConfigProperties appProperties = ConfigProperties.getInstance();
		
@Test
  public void partner_selection()  {
		
		 try {
			 ExtentTest test = extent.startTest("AXA Parner Selection Test ", " This test Validates Partner Selection functionality  for Home/Incident");
			
			 String username=appProperties.getProperty("Username");
			 String password=appProperties.getProperty("Password");
		
					
			 //login as AXA user
				CommonActions.AXALogin(test, driver, username, password);
				CommonActions.AXAPartnerSelection(test, driver);
				CommonActions.AXALogOut(driver, test);
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
