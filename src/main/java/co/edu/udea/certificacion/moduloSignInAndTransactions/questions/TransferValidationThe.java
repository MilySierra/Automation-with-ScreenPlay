package co.edu.udea.certificacion.moduloSignInAndTransactions.questions;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.TransferObjects.ERROR_MESSAGE;
import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.TransferObjects.MESSAGE;

@RequiredArgsConstructor
public class TransferValidationThe implements Question<Boolean> {

    public final String type;

    @Override
    public Boolean answeredBy(Actor actor) {
        if (type.equals("completed")){
            String message = BrowseTheWeb.as(actor).find(MESSAGE).getText();
            return message.equals("Transfer Complete!");
        } else {
            String message = BrowseTheWeb.as(actor).find(ERROR_MESSAGE).getText();
            return message.equals("Error!");
        }
    }

    public static TransferValidationThe message(){
        return new TransferValidationThe("completed");
    }

    public static TransferValidationThe messageWithIncompleteInformation(){
        return new TransferValidationThe("incompleted");
    }
}
