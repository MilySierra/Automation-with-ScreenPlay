package co.edu.udea.certificacion.moduloSignInAndTransactions.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.signUp.PASSWORD;
import static co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.signUp.USERNAME;
import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.SignInObjects.*;

public class logIn implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(USERNAME).into(INPUT_USERNAME_LOG_IN));
        actor.attemptsTo(Enter.theValue(PASSWORD).into(INPUT_PASSWORD_LOG_IN));
        actor.attemptsTo(Click.on(BUTTON_LOG_IN));
    }

    public static logIn user(){
        return Tasks.instrumented(logIn.class);
    }
}
