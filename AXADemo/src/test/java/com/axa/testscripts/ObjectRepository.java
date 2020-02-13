package com.axa.testscripts;

import org.openqa.selenium.By;

import com.axa.base.TestBase;
import com.axa.utilities.Utilities;



/*This class maintains web elements of all pages in AXA and these would be reused through out the project */
 
 /* @author AXA USI Team*/

public class ObjectRepository extends TestBase{

	public static ObjectRepository keyword = new ObjectRepository();
	
	/* some fixed values  */
	public static final String newPassword ="11";
	public static final String Duedate= Integer.toString(27);
	public static final String PostTestDuedate= Integer.toString(20);
	public static final String submissionDate_CreateClass = Integer.toString(Utilities.GetCurrentDay());
	public static final String prodname ="AXA";
	
	
	
	
	
	
	/* Login Page */
	
	public static By username = By.xpath("//input[@type='email'][@name='username']");
	public static By password = By.xpath("//input[@type='password'][@name='pw']");
	public static By login_button = By.xpath("//input[@type='submit'][@name='Login']");
	
	
	/* Logout Page */
	public static By logout_icon = By.xpath("//span[@class='uiImage']");
	public static By logout_button = By.xpath("//a[text()='Log Out']");
	
	/* AXA AssistAance APP launcher */
	public static By app_launcher = By.xpath("//div[@class='slds-icon-waffle']");
	public static By search_app = By.xpath("//input[@class='slds-input input']");
	public static By search_app_sat = By.xpath("//input[@placeholder='Search apps and items...']");
		
	/* waiting Page */
	public static By waiting_screen = By.xpath("//mark[text()='Waiting Screen']");
	public static By waiting_screen_sat = By.xpath("//span[@class='title slds-truncate']");
	//span[@class='title slds-truncate']
	public static By patient_enroll_form = By.xpath("//a[text()='Patient Enrollment Form']");
	public static By patient_firstname= By.xpath("//input[@type='text'][@name='pageId:formId:pb:pbs:fn']");
	public static By enroll_button= By.xpath("//input[@type='submit'][@name='pageId:formId:pb:j_id1:bottom:enrol']");
	public static By get_status= By.xpath("//td[text()='Not Started']");
	
	

	

	/*partner selection page */
	
	public static By Partner_picklist = By.xpath("//input[@type='text'][@name='partner']");
	public static By quickSearch_button = By.xpath("//button[text()='Quick Search']");
	public static By registrationnumber_textbox = By.xpath("//input[@type='text'][@name='callerInfo.registrationNumber']");
	public static By policynumber_textbox = By.xpath("//input[@type='text'][@name='callerInfo.policyNumber']");
	public static By firstname_textbox = By.xpath("//input[@type='text'][@name='callerInfo.firstName']");
	public static By lastname_textbox = By.xpath("//input[@type='text'][@name='callerInfo.lastName']");
	public static By salutation_textbox = By.xpath("//input[@type='text'][@name='callerInfo.salutation']");
	public static By mobilenumber_textbox = By.xpath("//input[@type='text'][@name='callerInfo.mobilePhoneNumber']");
	public static By secondaryphonenumber_textbox = By.xpath("//input[@type='text'][@name='callerInfo.secondaryPhoneNumber']");
	public static By security_identity_checkbox = By.xpath("//span[@class='slds-checkbox_faux']");
	public static By create_case_button = By.xpath("//button[text()='Create Case']");
	public static By AXA_Partner = By.xpath("//span[@title='AXA']");
	
	

	
	public static By Home_tab = By.xpath("//span[text()='Home']");
	public static By Planned = By.xpath("//span[text()='Planned']");
	public static By Emergency = By.xpath("//span[text()='Emergency']");
	public static By RFI = By.xpath("//span[text()='RFI']");	
	public static By Motor_tab = By.xpath("//span[text()='Motor']");
	public static By Accident = By.xpath("//span[text()='Accident']");
	public static By Breakdown = By.xpath("//span[text()='Breakdown']");
	
	/* cases */
	public static By AXA_Assistance_icon = By.xpath("//div[@class='slds-icon-waffle']");
	public static By cases = By.xpath("//span[text()='Cases']");
	public static By new_case = By.xpath("//div[text()='New']");
	public static By case_Search_bar = By.xpath("//*[@name='Case-search-input']");
	public static By search_required_case = By.xpath("//a[text()='00023115']");
	public static By related_link = By.xpath("//a[text()='Related']");
	
	
	
	public static By CMS_Create_case = By.xpath("//span[text()='CMS Create Case']"); 
	public static By CMS_Complaint = By.xpath("//span[text()='CMS Complaint']"); 
	public static By CMS_Identifier = By.xpath("//span[text()='CMS Identifier']"); 
	public static By CMS_Extra = By.xpath("//span[text()='CMS Extra']"); 
	public static By CMS_Send_provider= By.xpath("//span[text()='CMS Send Provider']"); 
	public static By CMS_Summary = By.xpath("//span[text()='CMS Summary']"); 
	public static By CMS_Emergency_Home = By.xpath("//span[text()='Emergency Home']"); 
	public static By Complaint = By.xpath("//span[text()='Complaint']"); 
	public static By CMS_Emergency_Motor = By.xpath("//span[text()='Emergency Motor']"); 
	public static By CMS_RFI = By.xpath("//span[text()='RFI']"); 
	public static By CMS_Cancel = By.xpath("//span[text()='Cancel']"); 
	public static By CMS_Next = By.xpath("//span[text()='Next']");
	
	
	
	/* Policy Snapshot */
	public static By Casenumber = By.xpath("//text()[.='00054955']/ancestor::span[1]");
	
	
	
	public static By CMS_Con =By.xpath("//span[@title='Contacts']");
    public static By Con_New = By.xpath("//div[@title='New']"); 
    public static By Con_Next = By.xpath("//span[text()='Next']");
    public static By Con_LastName = By.xpath("//input[@type='text'][@placeholder='Last Name']");
    public static By Con_NoSurvey = By.xpath("//span[text()='No Survey']");
    public static By Con_Save = By.xpath("//button[@title='Save']");
    //public static By Con_Details = By.xpath("//a[@title='Details']");
    public static By Con_Details = By.xpath("//a[@title='Details']//child::span");
    public static By Con_NScheckbox = By.xpath("//span[text()='No Survey']/parent::div/following-sibling::div/child::span/child::span");
    public static By Con_NSchkbox_editmode = By.xpath("//span[text()='No Survey']/parent::label/following-sibling::input");
    public static By Con_NSedit = By.xpath("//button[@title='Edit No Survey']");


	
	
	
	

	
	
	
	
	
	
		

	
	
	
	
	
	
	
	
	
	
	
}
