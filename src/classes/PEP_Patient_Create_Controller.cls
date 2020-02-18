/*********************************************************************************************************
Class Name      : PEP_Patient_Create_Controller
Description     : Controller for Patient Enrollment Form
Created By      : Abhinav Gadepalli
Created Date    : Feb 28, 2018
Modification Log:
--------------------------------------------------------------------------------------------------------------
Developer                     Date                      Description
--------------------------------------------------------------------------------------------------------------
Abhinav Gadepalli             Feb 28, 2018              Initial Version
****************************************************************************************************************/
public with sharing class PEP_Patient_Create_Controller{
    
    public PEP_Patient__c patientRecord {get; set;}
    public PEP_Patient_Address__c patientAddressRecord {get; set;}
    
    public PEP_Patient_Create_Controller(ApexPages.StandardController controller) {
        patientRecord = new PEP_Patient__c();
        patientAddressRecord = new PEP_Patient_Address__c();
    }
    //New Comment 4
    public PageReference saveDetails(){
        insert patientRecord;
        patientAddressRecord.Patient__c = patientRecord.Id;
        insert patientAddressRecord;
        PageReference pg = new PageReference('/'+patientRecord.Id);
        pg.setRedirect(true);
        return pg;
    }
}