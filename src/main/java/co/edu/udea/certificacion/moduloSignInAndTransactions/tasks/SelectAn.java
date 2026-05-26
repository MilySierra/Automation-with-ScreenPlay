package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.view;
import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

@RequiredArgsConstructor
public class SelectAn implements Task {

    public final String type;

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (type.equals("new")){
            actor.attemptsTo(view.newAccount());
            Wait.waitSomeMills(5000);
        } else {
            actor.attemptsTo(view.defaultAccount());
            Wait.waitSomeMills(5000);
        }

    }

    public static SelectAn newAccount(){
        return Tasks.instrumented(SelectAn.class, "new");
    }

    public static SelectAn defaultAccount(){
        return Tasks.instrumented(SelectAn.class, "default");
    }
}
