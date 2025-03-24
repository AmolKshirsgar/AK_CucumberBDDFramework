Feature: Registartion functionality

Scenario: User creates account only with mandotary fields
Given User navigates to Register Account page
When User enters details in below fields
|firstName	|Virat						|
|lastName		|Sharma						|
|telephone	|1234567890				|
|password		|12345						|
And User select Provacy Policy
And User clicks on Continue button
Then User account should get created successfully


Scenario: User creates account only with all fields
Given User navigates to Register Account page
When User enters details in below fields
|firstName	|Virat						|
|lastName		|Sharma						|
|telephone	|1234567890				|
|password		|12345						|
And User selects Yes for Newsletter 
And User select Provacy Policy
And User clicks on Continue button
Then User account should get created successfully


Scenario: User creates duplicate account
Given User navigates to Register Account page
When User enters details in below fields with duplicate email
|firstName	|Virat						|
|lastName		|Sharma						|
|email			|virat@sharma.com	| 
|telephone	|1234567890				|
|password		|12345						|
And User selects Yes for Newsletter 
And User select Provacy Policy
And User clicks on Continue button
Then User should get proper warning about duplicate email



Scenario: User creates account without filling any details
Given User navigates to Register Account page
When User dont enters any details into fields
And User clicks on Continue button
Then User should get proper warning message for every mandatory fields 