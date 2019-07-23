trigger PEP_Trigger_Patient on PEP_Patient__c (after insert) {

    if(trigger.isAfter){
        if(trigger.isInsert){
            PEP_Trigger_Handler_Patient.createFollowupTask(trigger.new);
        }
    }
}