Feature: Login functionality

  @ValidUserLogin
  Scenario: User should be able to login with valid username and password
    Given User on login page
    When User enter username and password click on login button
    Then User successfully login to the system