package co.edu.udea.certificacion.moduloSignInAndTransactions.stepdefinitions;

import co.edu.udea.certificacion.moduloSignInAndTransactions.questions.TransactionValidationThe;
import co.edu.udea.certificacion.moduloSignInAndTransactions.questions.viewValidationThe;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.TransactionEnter;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.TransactionOpen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class TransactionsStepDefinition {

    private Actor user() {
        return OnStage.theActorInTheSpotlight();
    }

    @Given("that I am on the request loan page")
    public void thatIAmOnTheRequestLoanPage() {
        TransactionOpen.browser();
    }
    @When("I enter the pain information but leave one field empty")
    public void iEnterThePainInformationButLeaveOneFieldEmpty() {
        user().attemptsTo(TransactionEnter.information(200,null));
    }
    @Then("I can see a message indicating that all fields are required")
    public void iCanSeeAMessageIndicatingThatAllFieldsAreRequired() {
        GivenWhenThen.then(user()).should(seeThat(TransactionValidationThe.message(), containsString("Error!")));
    }

    @When("I enter a {int} and a {int}")
    public void iEnterAAndA(Integer int1, Integer int2) {
        user().attemptsTo(TransactionEnter.information(int1,int2));
    }

    @Then("I can see the loan confirmation")
    public void iCanSeeTheLoanConfirmation() {

    }
}
