Feature: DeleteLead Functionality

Scenario: Delete Lead scenario
When Click Leads link
Then Verify Leads Page
When Click Find Lead link
Then Verify Find Lead Page
When Click Phone tab and Phone details as '99'
And  Click Find button and select the first link
And Click the DeleteLead
Then Check the LeadId in find Leads Page and verify no records