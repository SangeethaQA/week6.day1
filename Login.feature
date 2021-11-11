Feature: TestLeafTaps login functionality

Background:
Given open the chrome browser
And Load the application url as 'http://leaftaps.com/opentaps/'


Scenario Outline: Test with postive credential
Given Enter the username as <username>
And enter the password as <password>
When Click on login button 
Then Home page should be displayed
Examples:
|username|password|
|'Demosalesmanager'|'crmsfa'|
|'Democsr'|'crmsfa'|

Scenario: Test with negative credential

Given Enter the username as 'Demo'
And enter the password as 'crmsfa'
When Click on login button 
But error msg displayed
