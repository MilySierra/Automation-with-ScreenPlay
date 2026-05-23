package co.edu.udea.certificacion.moduloSignInAndTransactions.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.ParaBankObjects.BUTTON_LOG_OUT;

public class logOut implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BUTTON_LOG_OUT));
    }

    public static logOut user(){
        return Tasks.instrumented(logOut.class);
    }
}
