package co.edu.udea.certificacion.moduloSignInAndTransactions.stepdefinitions;

import co.edu.udea.certificacion.moduloSignInAndTransactions.questions.validationThe;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.Enter;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.Leave;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.OpenThe;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowsingTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.signUp.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class SignUpStepDefinition {

    public final Actor user = Actor.named("Daniella");

    @Managed(driver="chrome", uniqueSession = false)
    public WebDriver theDriver;

    @Before
    public void config(){
        user.can(BrowsingTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }

    @Given("that I am on the sign-up page")
    public void thatIAmOnTheSignUpPage() {
        user.attemptsTo(OpenThe.browser());
    }

    @When("I enter my basic information")
    public void iEnterMyBasicInformation() {
        user.attemptsTo(Enter.information());
    }

    @Then("I can see the welcome message")
    public void iCanSeeTheWelcomeMessage() {
        GivenWhenThen.then(user).should(seeThat(validationThe.homePage(), equalTo("Welcome "+USERNAME)));
    }

    @Given("that I am on the home page")
    public void thatIAmOnTheHomePage() {
        user.attemptsTo(OpenThe.homePage());
    }
    @When("I log out")
    public void iLogOut() {
        user.attemptsTo(Leave.session());
    }
    @Then("I can see the log-in page")
    public void iCanSeeTheLogInPage() {
        GivenWhenThen.then(user).should(seeThat(validationThe.logInPage(), equalTo("Customer Login")));
    }

    @When("I enter my information but leave one field empty")
    public void iEnterMyInformationButLeaveOneFieldEmpty(){
        user.attemptsTo(Enter.informationIncomplete());
    }

    @Then("I can see a message indicating that this field is required")
    public void iCanSeeAMessageIndicatingThatThisFieldIsRequired(){
        GivenWhenThen.then(user).should(seeThat(validationThe.requiredField(), containsString("is required")));
    }

    @Given("that I am on the log-in page")
    public void thatIAmOnTheLogInPage() {
        user.attemptsTo(OpenThe.logInBrowser());
    }

    @When("I enter my credentials")
    public void iEnterMyCredentials() {
        user.attemptsTo(Enter.credentials());
    }
    @Then("I can see my accounts information")
    public void iCanSeeMyAccountsInformation() {
        GivenWhenThen.then(user).should(seeThat(validationThe.ownPage(), equalTo("Accounts Overview")));
    }


}
