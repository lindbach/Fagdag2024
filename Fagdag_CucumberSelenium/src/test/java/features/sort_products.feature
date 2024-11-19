Feature: Sort products
  As a user
  I want to sort products by price or name
  So that I can find items more easily

  @WIP
  Scenario: Sort products by price (low to high)
    Given I am logged in to Swag Labs
    And I am on the products page
    When I sort products by "Price (low to high)"
    Then the first product should be the cheapest

  @WIP
  Scenario: Sort products by name (A to Z)
    Given I am logged in to Swag Labs
    And I am on the products page
    When I sort products by "Name (A to Z)"
    Then the first product should be alphabetically first
