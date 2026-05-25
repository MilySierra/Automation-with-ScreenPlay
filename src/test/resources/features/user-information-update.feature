Feature: as user I can update my profile information for change outdated data

  @requiresLogin
  Scenario: update profile information successful
    Given that I am on the update profile page
    When I enter my update information
    Then I can see a confirmation message that my profile was updated

  @requiresLogin
  Scenario: update profile with empty field - exception
    Given that I am on the update profile page
    When I submit the form leaving the field empty
    Then I can see a message indicating that field is required
