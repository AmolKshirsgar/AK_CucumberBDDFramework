Feature: End to End scenario for placing order

Scenario: Verify if user is able to place the order
Given User login to the application
When User enters valid email address "akk@test.com" into email field.
And User enters valid password address "ak123" into password field.
And User clicks on login button.
When User add a product "HP LP3065" to a bag and checkout
And User place an order
Then User should see the order placed successfully