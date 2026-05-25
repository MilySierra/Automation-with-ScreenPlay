package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.view;
import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SelectAn implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(view.account());
        Wait.waitSomeMills(5000);
    }

    public static SelectAn account(){
        return Tasks.instrumented(SelectAn.class);
    }
}
