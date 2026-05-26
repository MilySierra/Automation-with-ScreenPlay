package co.edu.udea.certificacion.moduloSignInAndTransactions.questions;

import co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.TransactionObjects;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.TransactionObjects.ERROR_MESSAGE_LOAN;
import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.TransactionObjects.MESSAGE_LOIN;

@RequiredArgsConstructor
public class TransactionValidationThe implements Question<String> {

    private final boolean incomplete;

    @Override
    public String answeredBy(Actor actor) {
        if (incomplete){
            return BrowseTheWeb.as(actor).find(ERROR_MESSAGE_LOAN).getText();
        } else {
            return BrowseTheWeb.as(actor).find(MESSAGE_LOIN).getText();
        }
    }

    public static TransactionValidationThe transaction(){
        return new TransactionValidationThe(false);
    }

    public static TransactionValidationThe transactionIncomplete(){
        return new TransactionValidationThe(true);
    }
}
