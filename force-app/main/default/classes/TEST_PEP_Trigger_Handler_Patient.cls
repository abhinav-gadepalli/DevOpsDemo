@isTest
public with sharing class TEST_PEP_Trigger_Handler_Patient{
    public static testmethod void testInsertPatient(){
        test.startTest();
        PEP_Patient__c pat = new PEP_Patient__c();
        pat.Gender__c = 'Male';
        insert pat ;
        system.assertEquals(pat.Gender__c,'Male');
        Test.StopTest();
    }

}