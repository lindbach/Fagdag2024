Feature: Logout from Swag Labs
  As a user
  I want to log out of the Swag Labs site
  So that my session is secure

  @WIP
  Scenario: Logout from the products page
    Given I am logged in to Swag Labs
    When I click the logout button
    Then I should be redirected to the login page
