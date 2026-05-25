Feature: as a user I want to create financial account so I can manage my money

  @requiresRegisterAndLogOut
  Scenario Outline: Create a new <accountType> account successfully
    Given that I am on the open account page
    When I request the creation of a <accountType> account
    Then I can see the confirmation of the <accountType> account creation

    Examples:
      | accountType |
      | Savings     |
      | Checking    |

  Scenario: Try to create an account without being logged in - exception
    Given that I am not logged in
    When I try to access the open account page
    Then I can see the login page instead of the form