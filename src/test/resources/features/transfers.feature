Feature: as user I can transfer funds between my accounts

  @requiresLogin
  Scenario: transfer successful
    Given that I am on the transfers page
    When I enter the transfer information
    Then I can see a message indicating that the transfer was successful

  Scenario: transfer with empty fields - exception
    Given that I am on the transfers page
    When I enter the transfer information but leave the amount field empty
    Then I can see a error message