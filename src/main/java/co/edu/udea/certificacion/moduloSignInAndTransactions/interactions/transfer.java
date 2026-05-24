package co.edu.udea.certificacion.moduloSignInAndTransactions.interactions;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.TransferObjects.*;

@RequiredArgsConstructor
public class transfer implements Interaction {

    public final Integer AMOUNT;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(String.valueOf(AMOUNT)).into(INPUT_AMOUNT));
        actor.attemptsTo(SelectFromOptions.byIndex(0).from(INPUT_FROM_ACCOUNT));
        actor.attemptsTo(SelectFromOptions.byIndex(0).from(INPUT_TO_ACCOUNT));
        actor.attemptsTo(Click.on(BUTTON_TRANSFER));

    }

    public static transfer funds(){
        return Tasks.instrumented(transfer.class, 200);
    }

    public static transfer fundsWithFieldsEmpty(){
        return Tasks.instrumented(transfer.class, (Integer) null);
    }
}
