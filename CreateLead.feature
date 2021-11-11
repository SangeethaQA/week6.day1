Feature: CreateLead Functionality



Scenario: CreateLead scenario
When Click Leads link
Then Verify Leads Page
When Click Create Lead link
Then Verify CreateLead Page
Given Enter the company name as 'TestLeaf' and first name as 'Hari' and last name as 'R' 
And  Enter the phone number as '434829'
When Click Submit button
Then Verify View Lead Page
