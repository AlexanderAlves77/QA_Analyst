Feature: User API Validation
  Scenario: Create a new user successfully
    Given I have a valid user payload
    When I send a POST request to "/api/users"
    Then the status code should be 201
    And the user should be persisted in the database