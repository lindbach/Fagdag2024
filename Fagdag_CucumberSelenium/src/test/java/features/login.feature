Feature: Login to Swag Labs
  As a user
  I want to log in to the Swag Labs site
  So that I can access the products page

  Scenario: Successful login with valid credentials
    Given I am on the Swag Labs login page
    When I enter a valid username and password
    And I click the login button
    Then I should see the products page

  Scenario: Failed login with invalid credentials
    Given I am on the Swag Labs login page
    When I enter an invalid username or password
    And I click the login button
    Then I should see an error message
