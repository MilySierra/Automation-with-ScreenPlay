package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.SignInObjects;
import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

public class Leave implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean isLoggedIn = BrowseTheWeb.as(actor)
            .findAll(SignInObjects.BUTTON_LOG_OUT)
            .size() > 0;

        if (isLoggedIn) {
            actor.attemptsTo(Click.on(SignInObjects.BUTTON_LOG_OUT));
            Wait.waitSomeMills(2000);
        }
    }

    public static Leave session(){
        return Tasks.instrumented(Leave.class);
    }
}
