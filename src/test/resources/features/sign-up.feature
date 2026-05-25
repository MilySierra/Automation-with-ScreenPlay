Feature: as a user I can sign up in the platform for use the different services

  Scenario: sign up successful
    Given that I am on the sign-up page
    When I enter my basic information
    Then I can see the welcome message

  Scenario: log out successful
    Given that I am on the home page
    When I log out
    Then I can see the log-in page

  Scenario: log in successful
    Given that I am on the log-in page
    When I enter my credentials
    Then I can see my accounts information

  Scenario: sign up with empty fields - exception
    Given that I am on the sign-up page
    When I enter my information but leave one field empty
    Then I can see a message indicating that this field is required

