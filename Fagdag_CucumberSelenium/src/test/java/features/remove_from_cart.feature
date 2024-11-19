Feature: Remove products from the cart
  As a user
  I want to remove products from my cart
  So that I can update my cart contents
  @WIP
  Scenario: Remove a product from the cart
    Given I have added "Sauce Labs Backpack" to the cart
    And I am on the cart page
    When I remove the "Sauce Labs Backpack"
    Then I should see the cart is empty
