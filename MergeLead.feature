Feature: MergeLead Functionality



Scenario: MergeLead scenario
When Click Leads link
Then Verify Leads Page
When Click Merge Leads link
Then Verify Merge Leads Page
When From Lead as 'Hari' and To Lead as 'Babu'
And click Merge button and Click Alert message
Then Check the LeadId in find Leads Page and verify no records

