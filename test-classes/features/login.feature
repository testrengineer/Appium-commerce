Feature: Login

  Scenario: Successful Login with valid credential
    Given user in homepage
    When user navigate to login page
    And user log in with valid username and password
    Then user successfully login

  Scenario: Failed Login with locked out user
    Given user in homepage
    When user navigate to login page
    And user log in with locked out username and password
    Then user failed to login with locked out error

  Scenario: Failed Login with empty username
    Given user in homepage
    When user navigate to login page
    And user log in with empty username
    Then user failed to login with error username "Username is required"

  Scenario: Failed Login with empty password
    Given user in homepage
    When user navigate to login page
    And user log in with empty password
    Then user failed to login with error password "Enter Password"