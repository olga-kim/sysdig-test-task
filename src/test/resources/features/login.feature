@login
Feature: Login

#  Scenario: User can login with valid credentials
#    Given Navigate to Login Page
#    When User enters a valid email and valid password
#    And User clicks on Log in button
#    Then User is logged in successfully

  Scenario: Invalid credentials are not allowed
    Given Navigate to Login Page
    When User enters invalid credentials
    And User clicks on Log in button
    Then Error message is displayed

  Scenario: User can open a page to restore a password
    Given Navigate to Login Page
    When User clicks on Forgot password link
    Then Forgot password page is opened