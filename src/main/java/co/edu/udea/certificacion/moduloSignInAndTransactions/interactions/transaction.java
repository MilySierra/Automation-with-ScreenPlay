package co.edu.udea.certificacion.moduloSignInAndTransactions.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.TransactionObjects.*;

public class transaction implements Interaction {

    private final Integer loanAmount;
    private final Integer downPayment;

    public transaction(Integer loanAmount, Integer downPayment) {
        this.loanAmount = loanAmount;
        this.downPayment = downPayment;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(String.valueOf(loanAmount)).into(INPUT_AMOUNT_LOAN));
        actor.attemptsTo(Enter.theValue(String.valueOf(downPayment)).into(INPUT_DOWN_LOAN));
        actor.attemptsTo(SelectFromOptions.byIndex(0).from(INPUT_FROM_ACCOUNT_LOAN));
        actor.attemptsTo(Click.on(BUTTON_LOAN));

    }

    public static transaction amount(Integer amount, Integer downPayment) {
        return Tasks.instrumented(transaction.class, amount, downPayment);
    }


}
