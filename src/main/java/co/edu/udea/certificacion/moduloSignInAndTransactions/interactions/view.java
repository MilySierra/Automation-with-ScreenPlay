package co.edu.udea.certificacion.moduloSignInAndTransactions.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.ViewObjects.ACCOUNT_LINK;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class view implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String accountId = actor.recall("newAccountId");
        if (accountId == null || accountId.trim().isEmpty()) {
            throw new IllegalStateException("No hay una cuenta guardada para seleccionar");
        }
        accountId = accountId.trim();
        actor.attemptsTo(WaitUntil.the(ACCOUNT_LINK(accountId), isVisible()).forNoMoreThan(10).seconds());
        actor.attemptsTo(Click.on(ACCOUNT_LINK(accountId)));
    }

    public static view account(){
        return Tasks.instrumented(view.class);
    }
}


