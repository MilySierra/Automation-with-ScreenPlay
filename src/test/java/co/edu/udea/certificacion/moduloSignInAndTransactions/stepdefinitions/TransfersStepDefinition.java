package co.edu.udea.certificacion.moduloSignInAndTransactions.stepdefinitions;

import co.edu.udea.certificacion.moduloSignInAndTransactions.questions.SignInValidationThe;
import co.edu.udea.certificacion.moduloSignInAndTransactions.questions.TransferValidationThe;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.TransferEnter;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.TransferOpenThe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class TransfersStepDefinition {

    private Actor user() {
        return OnStage.theActorInTheSpotlight();
    }

    @Given("that I am on the transfers page")
    public void thatIAmOnTheTransfersPage() {
        user().attemptsTo(TransferOpenThe.browser());
    }

    @When("I enter the transfer information")
    public void iEnterTheTransferInformation() {
        user().attemptsTo(TransferEnter.information());
    }

    @Then("I can see a message indicating that the transfer was successful")
    public void iCanSeeAMessageIndicatingThatTheTransferWasSuccessful() {
        GivenWhenThen.then(user()).should(seeThat(TransferValidationThe.message()));
    }

    @When("I enter the transfer information but leave the amount field empty")
    public void iEnterTheTransferInformationButLeaveTheAmountFieldEmpty() {
        user().attemptsTo(TransferEnter.informationIncomplete());
    }

    @Then("I can see a error message")
    public void iCanSeeAErrorMessage() {
        GivenWhenThen.then(user()).should(seeThat(TransferValidationThe.messageWithIncompleteInformation()));
    }
}
