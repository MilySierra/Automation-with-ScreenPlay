package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class TransactionOpen implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().thePageNamed("pages.paraBankRequestLoanUrl"));
        Wait.waitSomeMills(5000);
    }

    public static TransactionOpen browser(){
        return Tasks.instrumented(TransactionOpen.class);
    }
}
