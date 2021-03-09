Feature: Admin user should be able to add, delete, edit customer information

  Background:
    Given User on login page
    When User enter username and password click on login button
    Then User successfully login to the system

  @addCustomerTest
  Scenario: User should be able to add customer
    Given User already on the dashboard page
    When User click on Customer List link
    And User click on Add Customer link to fill out all customer information
    Then New customer should be added

  @deleteCustomer
  Scenario: User should be able to delete customer
    Given User already on the dashboard page
    When User click on Customer List link
    And User click on delete icon
    Then User should be deleted successfully
