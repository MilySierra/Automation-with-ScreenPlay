package co.edu.udea.certificacion.moduloSignInAndTransactions.questions;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.AccountObjects.CONFIRMATION_MESSAGE;

@RequiredArgsConstructor
public class AccountValidationThe implements Question<Boolean> {

    public final String type;

    @Override
    public Boolean answeredBy(Actor actor) {
        if (type.equals("opened")) {
            String message = BrowseTheWeb.as(actor).find(CONFIRMATION_MESSAGE).getText();
            return message.equals("Account Opened!");
        }
        return false;
    }

    public static AccountValidationThe confirmationMessage() {
        return new AccountValidationThe("opened");
    }
}