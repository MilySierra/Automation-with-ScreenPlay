package co.edu.udea.certificacion.moduloSignInAndTransactions.interactions;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.AccountObjects.*;

@RequiredArgsConstructor
public class openAccount implements Interaction {

    public final String accountType;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(OPEN_NEW_ACCOUNT_LINK));
        actor.attemptsTo(SelectFromOptions.byVisibleText(accountType).from(ACCOUNT_TYPE_DROPDOWN));
        actor.attemptsTo(SelectFromOptions.byIndex(0).from(FROM_ACCOUNT_DROPDOWN));
        actor.attemptsTo(Click.on(OPEN_ACCOUNT_BUTTON));
    }

    public static openAccount savings() {
        return Tasks.instrumented(openAccount.class, "SAVINGS");
    }

    public static openAccount checking() {
        return Tasks.instrumented(openAccount.class, "CHECKING");
    }
}