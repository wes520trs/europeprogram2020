@DataBaseTest
  Feature: User should be able to view product information in the cc_CubeCart_inventory table
    Scenario: User should be able to get product info
      Given A user has access to the cc_CubeCart_inventory table
      When User query the query script in the cc_CubeCart_inventory table
      Then User should see the product info
