package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.logOut;
import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Leave implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(logOut.user());
        Wait.waitSomeMills(5000);
    }

    public static Leave session(){
        return Tasks.instrumented(Leave.class);
    }
}
