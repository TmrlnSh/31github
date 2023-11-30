Feature: Verify Deposit Feature

  Scenario: Verify user can create deposit money to the account
    Given user open the website
    When user enter the username "login.username" and password "login.password"
    Then verify user is navigated to homepage
    When user click on Deposit tab
    Then verify deposit into account page is displayed
    When user select account from the dropdown
    And  enter the deposit amount
    And click on submit Button
    Then verify view checking and savings account page is displayed
    And verify deposit entry is displayed in the transaction history

