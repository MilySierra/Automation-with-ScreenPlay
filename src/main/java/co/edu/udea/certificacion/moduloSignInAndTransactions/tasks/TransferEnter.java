package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.transfer;
import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

@RequiredArgsConstructor
public class TransferEnter implements Task {

    public final String type;

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (type.equals("completed")){
            actor.attemptsTo(transfer.funds());
            Wait.waitSomeMills(5000);
        } else {
            actor.attemptsTo(transfer.fundsWithFieldsEmpty());
            Wait.waitSomeMills(5000);
        }
    }

    public static TransferEnter information(){
        return Tasks.instrumented(TransferEnter.class, "completed");
    }

    public static TransferEnter informationIncomplete(){
        return Tasks.instrumented(TransferEnter.class, "incompleted");
    }
}
