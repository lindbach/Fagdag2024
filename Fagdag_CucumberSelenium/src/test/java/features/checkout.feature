Feature: Checkout process
  As a user
  I want to complete the checkout process
  So that I can purchase my selected products

  @login
  Scenario: Successful checkout with valid information
    Given I have added "Sauce Labs Backpack" to the cart
    And I am on the checkout page
    When I enter valid shipping details
      | FirstName | John  |
      | LastName  | Doe   |
      | ZipCode   | 12345 |
    And I click the continue button
    And I click the finish button
    Then I should see a confirmation message

  @login
  Scenario: Checkout failure with missing information
    Given I have added "Sauce Labs Backpack" to the cart
    And I am on the checkout page
    When I leave the shipping details blank
    And I click the continue button
    Then I should see an error message

