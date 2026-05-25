package co.edu.udea.certificacion.moduloSignInAndTransactions.stepdefinitions;

import co.edu.udea.certificacion.moduloSignInAndTransactions.questions.AccountValidationThe;
import co.edu.udea.certificacion.moduloSignInAndTransactions.questions.SignInValidationThe;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.AccountEnter;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.AccountOpenThe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class AccountCreationStepDefinition {
    private Actor user(){
        return OnStage.theActorInTheSpotlight();
    }

    @Given("that I am on the open account page")
    public void thatIAmOnTheOpenAccountPage(){
        user().attemptsTo(AccountOpenThe.browser());
    }

    @When("I request the creation of a {word} account")
    public void iRequestTheCreationOfAccount(String accountType) {
        if (accountType.equals("Savings")) {
            user().attemptsTo(AccountEnter.savings());
        } else {
            user().attemptsTo(AccountEnter.checking());
        }
    }

    @Then("I can see the confirmation of the {word} account creation")
    public void iCanSeeTheConfirmation(String accountType) {
        GivenWhenThen.then(user()).should(
            seeThat(AccountValidationThe.confirmationMessage(), equalTo(true))
        );
    }

    @Given("that I am not logged in")
    public void thatIAmNotLoggedIn() {
        // no hace nada — el actor simplemente no tiene sesión
    }

    @When("I try to access the open account page")
    public void iTryToAccessTheOpenAccountPage() {
        user().attemptsTo(AccountOpenThe.browser());
    }

    @Then("I can see the login page instead of the form")
    public void iCanSeeTheLoginPage() {
        GivenWhenThen.then(user()).should(
            seeThat(SignInValidationThe.logInPage(), equalTo("Customer Login"))
        );
    }
}