@ProductModule

Feature: Admin user should be able to add products, delete products

  Background:
    Given user on login page
    When user enter username and password click on login button
    Then user successfully login to the system

  @AddProducts
  Scenario: User should be able to add products
    Given User already on the dashboard page
    When User click on Products link
    And User click on Add Product tab to fill out product information
    Then New product should be added

    @DeleteProducts
    Scenario: User should be able to delete products
      Given User already on the dashboard page
      When User click on Products link
      And User click on delete icon
      Then Product should be deleted successfully