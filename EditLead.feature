Feature: EditLead Functionality



Scenario: EditLead scenario
When Click Leads link
Then Verify Leads Page
When Click Find Lead link
Then Verify Find Lead Page
When Click Phone tab and Phone details as '434829'
And  Click Find button and select the first link
And Click Edit button 
Then Verify Edit Lead Page
When Enter the company name as 'TCS'
And Click Submit button
Then Verify View Lead Page

