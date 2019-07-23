@isTest
public with sharing class TEST_PEP_Patient_Create_Controller{
    public static testmethod void testInsertPatient(){
        test.startTest();
        PEP_Patient__c pat = new PEP_Patient__c();
        pat.Gender__c = 'Male';
        insert pat ;
        system.assertEquals(pat.Gender__c,'Male');
        
        ApexPages.StandardController sc = new ApexPages.StandardController(pat);
        PEP_Patient_Create_Controller  cntrl= new PEP_Patient_Create_Controller(sc);
        
        PageReference pageRef = Page.PEP_Patient_Create;
        pageRef.getParameters().put('id', String.valueOf(pat.Id));
        Test.setCurrentPage(pageRef);
        cntrl.saveDetails();
        Test.StopTest();
    }

}