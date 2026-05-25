package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.updateInformation;
import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

@RequiredArgsConstructor
public class UpdateEnter implements Task {

    private final boolean incomplete;

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!incomplete) {
            actor.attemptsTo(updateInformation.user());
        } else {
            actor.attemptsTo(updateInformation.updateWithEmptyField());
        }
        Wait.waitSomeMills(5000);
    }

    public static UpdateEnter information() {
        return Tasks.instrumented(UpdateEnter.class, false);
    }

    public static UpdateEnter incompleteInformation() {
        return Tasks.instrumented(UpdateEnter.class, true);
    }
}