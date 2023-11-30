Feature: Verify Login Functionality

  Scenario: Verify user can login into the application
    Given user open the website
    When user enter the username "login.username" and password "login.password"
    Then verify user is navigated to homepage