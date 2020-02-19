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
public with sharing class PEP_Trigger_Handler_Patient{
    
    public static void createFollowupTask(List<PEP_Patient__c> patientList){
        List<Task> tasksToInsert = new List<Task>();
        
        Id userId = UserInfo.getUserId();
        for(PEP_Patient__c pat : patientList){
            Task t = new Task(WhatId = pat.Id, Subject = 'Follow-up with patient for services opt-in', OwnerId = userId, Status = 'Not Started', ActivityDate = System.today() + 5);
            

            tasksToInsert.add(t);
        }
        if(!tasksToInsert.isEmpty())
            insert tasksToInsert;  
    }
}
