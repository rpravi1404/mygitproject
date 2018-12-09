Feature: Application Login

Scenario: Login to the application
Given User is at Home page
When User enters valid "john" and "1234"
Then Login is "passed"

Scenario: Login to the application
Given User is at Home page
When User enters valid "ravi" and "4321"
Then Login is "failed"