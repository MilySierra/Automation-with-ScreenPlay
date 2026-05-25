Feature: as a user I can navigate between the different services

  Scenario: full flow
    Given that I am on the sign-up page
    When I enter my basic information
    Then I can see the welcome message

    Given that I am on the home page
    When I log out
    Then I can see the log-in page

    When I enter my credentials
    Then I can see my accounts information

    Given that I am on the open account page
    When I request the creation of a Savings account
    Then I can see the confirmation of the Savings account creation

    Given that I am on the transfers page
    When I enter the transfer information
    Then I can see a message indicating that the transfer was successful

    When I log out
    Then I can see the log-in page

