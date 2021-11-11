Feature: DuplicateLead Functionality

Scenario: Duplicate Lead scenario
When Click Leads link
Then Verify Leads Page
When Click Find Lead link
Then Verify Find Lead Page
When Click Phone tab and Phone details as '434829'
And  Click Find button and select the first link
And Click the DuplicateLead
And Click Submit button
Then Verify View Lead Page