package co.edu.udea.certificacion.moduloSignInAndTransactions.interactions;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.AccountObjects.*;
import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.ViewObjects.ACCOUNT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@RequiredArgsConstructor
public class openAccount implements Interaction {

    public final String accountType;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(OPEN_NEW_ACCOUNT_LINK));
        actor.attemptsTo(SelectFromOptions.byVisibleText(accountType).from(ACCOUNT_TYPE_DROPDOWN));
        actor.attemptsTo(SelectFromOptions.byIndex(0).from(FROM_ACCOUNT_DROPDOWN));
        actor.attemptsTo(Click.on(OPEN_ACCOUNT_BUTTON));
        actor.attemptsTo(WaitUntil.the(ACCOUNT, isVisible()).forNoMoreThan(10).seconds());
        String newAccountId = Text.of(ACCOUNT).answeredBy(actor).trim();
        if (newAccountId.isEmpty()) {
            throw new IllegalStateException("No se pudo obtener el numero de la cuenta creada");
        }
        actor.remember("newAccountId", newAccountId);
    }

    public static openAccount savings() {
        return Tasks.instrumented(openAccount.class, "SAVINGS");
    }

    public static openAccount checking() {
        return Tasks.instrumented(openAccount.class, "CHECKING");
    }
}
