package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.openAccount;
import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

@RequiredArgsConstructor
public class AccountEnter implements Task {

    private final String type;

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (type.equals("savings")) {
            actor.attemptsTo(openAccount.savings());
        } else {
            actor.attemptsTo(openAccount.checking());
        }
        Wait.waitSomeMills(5000);
    }

    public static AccountEnter savings() {
        return Tasks.instrumented(AccountEnter.class, "savings");
    }

    public static AccountEnter checking() {
        return Tasks.instrumented(AccountEnter.class, "checking");
    }
}