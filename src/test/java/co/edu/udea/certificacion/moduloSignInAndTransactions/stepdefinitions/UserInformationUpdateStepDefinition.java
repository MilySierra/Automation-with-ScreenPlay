package co.edu.udea.certificacion.moduloSignInAndTransactions.stepdefinitions;

import co.edu.udea.certificacion.moduloSignInAndTransactions.questions.UpdateValidationThe;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.UpdateEnter;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.UpdateOpenThe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class UserInformationUpdateStepDefinition {

    private Actor user() {
        return OnStage.theActorInTheSpotlight();
    }

    @Given("that I am on the update profile page")
    public void thatIAmOnTheUpdateProfilePage() {
        user().attemptsTo(UpdateOpenThe.browser());
    }

    @When("I enter my update information")
    public void iEnterMyUpdateInformation() {
        user().attemptsTo(UpdateEnter.information());
    }

    @Then("I can see a confirmation message that my profile was updated")
    public void iCanSeeAConfirmationMessageThatMyProfileWasUpdated() {
        GivenWhenThen.then(user()).should(seeThat(UpdateValidationThe.updatePage()));
    }

    @When("I submit the form leaving the field empty")
    public void iSubmitTheFormLeavingTheFieldEmpty() {
        user().attemptsTo(UpdateEnter.incompleteInformation());
    }

    @Then("I can see a message indicating that field is required")
    public void iCanSeeAMessageIndicatingThatFieldIsRequired() {
        GivenWhenThen.then(user()).should(seeThat(UpdateValidationThe.updatePageWithError()));
    }

}
