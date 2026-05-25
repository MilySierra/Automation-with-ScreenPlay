package co.edu.udea.certificacion.moduloSignInAndTransactions.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.ViewObjects.MESSAGE_ACCOUNT;

public class viewValidationThe implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(MESSAGE_ACCOUNT).getText();
    }

    public static viewValidationThe accountInformation(){
        return new viewValidationThe();
    }
}
