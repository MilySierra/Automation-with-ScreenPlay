package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.transaction;
import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

@RequiredArgsConstructor
public class TransactionEnter implements Task {

    private final Integer loanAmount;
    private final Integer downPayment;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(transaction.amount(loanAmount,downPayment));
        Wait.waitSomeMills(5000);
    }

    public static TransactionEnter information(Integer loanAmount, Integer downPayment){
        return Tasks.instrumented(TransactionEnter.class, loanAmount, downPayment);
    }
}
