package co.edu.udea.certificacion.moduloSignInAndTransactions.questions;

import co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.TransactionObjects;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.TransactionObjects.ERROR_MESSAGE_LOAN;

public class TransactionValidationThe implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(ERROR_MESSAGE_LOAN).getText();
    }

    public static TransactionValidationThe message(){
        return new TransactionValidationThe();
    }
}
