package co.edu.udea.certificacion.moduloSignInAndTransactions.stepdefinitions;

import co.edu.udea.certificacion.moduloSignInAndTransactions.questions.SignInValidationThe;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.SignInEnter;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.Leave;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.SignInOpenThe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.signUp.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class SignUpStepDefinition {

    private Actor user() {
        return OnStage.theActorInTheSpotlight();
    }

    @Given("that I am on the sign-up page")
    public void thatIAmOnTheSignUpPage() {
        user().attemptsTo(SignInOpenThe.browser());
    }

    @When("I enter my basic information")
    public void iEnterMyBasicInformation() {
        user().attemptsTo(SignInEnter.information());
    }

    @Then("I can see the welcome message")
    public void iCanSeeTheWelcomeMessage() {
        GivenWhenThen.then(user()).should(seeThat(SignInValidationThe.homePage(), equalTo("Welcome "+USERNAME)));
    }

    @When("I enter my information but leave one field empty")
    public void iEnterMyInformationButLeaveOneFieldEmpty(){
        user().attemptsTo(SignInEnter.informationIncomplete());
    }

    @Then("I can see a message indicating that this field is required")
    public void iCanSeeAMessageIndicatingThatThisFieldIsRequired(){
        GivenWhenThen.then(user()).should(seeThat(SignInValidationThe.requiredField(), containsString("is required")));
    }

    @Given("that I am on the log-in page")
    public void thatIAmOnTheLogInPage() {
        user().attemptsTo(SignInOpenThe.logInBrowser());
    }

    @When("I enter my credentials")
    public void iEnterMyCredentials() {
        user().attemptsTo(SignInEnter.credentials());
    }


    @Then("I can see my accounts information")
    public void iCanSeeMyAccountsInformation() {
        GivenWhenThen.then(user()).should(seeThat(SignInValidationThe.ownPage(), equalTo("Accounts Overview")));
    }

    @Given("that I am on the home page")
    public void thatIAmOnTheHomePage() {
        user().attemptsTo(SignInOpenThe.homePage());
    }

    @When("I log out")
    public void iLogOut() {
        user().attemptsTo(Leave.session());
    }

    @Then("I can see the log-in page")
    public void iCanSeeTheLogInPage() {
        GivenWhenThen.then(user()).should(seeThat(SignInValidationThe.logInPage(), equalTo("Customer Login")));
    }

}
