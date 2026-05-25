package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class AccountOpenThe implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().thePageNamed("pages.paraBankOpenAccountUrl"));
        Wait.waitSomeMills(5000);
    }

    public static AccountOpenThe browser(){
        return Tasks.instrumented(AccountOpenThe.class);
    }
}