package co.edu.udea.certificacion.moduloSignInAndTransactions.stepdefinitions;

import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.Leave;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.SignInEnter;
import co.edu.udea.certificacion.moduloSignInAndTransactions.tasks.SignInOpenThe;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowsingTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @Managed(driver = "chrome", uniqueSession = false)
    public WebDriver theDriver;

    @Before(order = 0)
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        Actor user = OnStage.theActorCalled("Daniella");
        user.can(BrowsingTheWeb.with(theDriver));
    }

    @Before(value = "@requiresLogin", order = 1)
    public void logInBeforeScenario() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SignInOpenThe.logInBrowser(),
                SignInEnter.credentials()
        );
    }

    @After(value = "@requiresLogin")
    public void logOutAfterScenario() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            Leave.session()
        );
    }
}
