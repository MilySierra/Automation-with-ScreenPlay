package co.edu.udea.certificacion.moduloSignInAndTransactions.stepdefinitions;

import co.edu.udea.certificacion.moduloSignInAndTransactions.questions.viewValidationThe;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.SelectAn;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.ViewOpenThe;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class ViewStepDefinition {

    private Actor user() {
        return OnStage.theActorInTheSpotlight();
    }

    @Given("that I am on the account overview page")
    public void thatIAmOnTheAccountOverviewPage() {
        user().attemptsTo(ViewOpenThe.browser());
    }
    @When("I select an account number")
    public void iSelectAnAccountNumber() {
        user().attemptsTo(SelectAn.account());
    }
    @Then("I can see my account information")
    public void iCanSeeMyAccountInformation() {
        GivenWhenThen.then(user()).should(seeThat(viewValidationThe.accountInformation(), containsString("Account Details")));

    }
}
