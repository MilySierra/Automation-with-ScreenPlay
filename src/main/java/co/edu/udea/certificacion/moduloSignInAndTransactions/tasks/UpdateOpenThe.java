package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class UpdateOpenThe implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().thePageNamed("pages.paraBankUpdateProfileUrl"));
        Wait.waitSomeMills(5000);
    }

    public static UpdateOpenThe browser() {
        return Tasks.instrumented(UpdateOpenThe.class);
    }
}

