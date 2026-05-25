Feature: as a user I can make different transactions as apply for a loan or pay bills

  @requiresRegister
  Scenario: request loan with fields empty - exception
    Given that I am on the request loan page
    When I enter the pain information but leave one field empty
    Then I can see a message indicating that all fields are required

  Scenario Outline: request loan successful
    Given that I am on the request loan page
    When I enter a <loanAmount> and a <downPayment>
    Then I can see the loan confirmation
    Examples:
      | loanAmount | downPayment |
      |500|100|
      |1000|20|
      |300|50|

