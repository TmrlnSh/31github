Feature: Verify checking and saving account functionality

  Scenario: Verify user can create new checking account
    Given user open the website
    When user enter the username "login.username" and password "login.password"
    Then verify user is navigated to homepage
    When user click on checking tab
    And click on New Checking button
    Then verify new checking account page is displayed
    When user enters new checking account details
    And click on submit button
    Then verify view checking account page is displayed
    And verify account creation success message is displayed
    And verify new account details updated in database

  Scenario: Verify user can create new savings account
    Given user open the website
    When user enter the username "login.username" and password "login.password"
    Then verify user is navigated to homepage
    When user click on savings tab
    And click on New Savings button
    Then verify new savings account page is displayed
    When user enters new savings account details
    And click on Submit button
    Then verify view savings account page is displayed
    And verify account creation success message is displayed

