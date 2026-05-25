Feature: as a user I can view my accounts information

  @requiresAccount
  Scenario: View new account information
    Given that I am on the account overview page
    When I select an account number
    Then I can see my account information

