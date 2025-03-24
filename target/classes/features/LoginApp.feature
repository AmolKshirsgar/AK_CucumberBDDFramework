Feature: Login Functionality

Scenario Outline: Login with valid credentials
Given User has navigated to login page
When User enters valid email address <username> into email field
And User enters valid password address <password> into password field
And User clicks on login button
Then User should get successfully logged in
Examples:
|username						|password	|
|akk@test.com				|ak123		|
|virat@sharma.com		|12345		|



Scenario: Login with invalid credentials
Given User has navigated to login page
When User enters invalid email address into email field     
And User enters invalid password address "ak12345" into password field
And User clicks on login button
Then User should get proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User has navigated to login page
When User enters valid email address "akk@test.com" into email field
And User enters invalid password address "ak12345" into password field
And User clicks on login button
Then User should get proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User has navigated to login page
When User enters invalid email address into email field
And User enters valid password address "ak123" into password field
And User clicks on login button
Then User should get proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User has navigated to login page
When User dont enter email into email field
And User dont enter password into password field
And User clicks on login button
Then User should get proper warning message about credentials mismatch



