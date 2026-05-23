package co.edu.udea.certificacion.moduloSignInAndTransactions.questions;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.ParaBankObjects.*;

@RequiredArgsConstructor
public class validationThe implements Question<String> {

    private final boolean incomplete;
    private final String type;

    @Override
    public String answeredBy(Actor actor) {
        if (type.equals("register")) {
            if (incomplete) {
                return BrowseTheWeb.as(actor).find(ERROR_MESSAGE).getText();
            } else {
                return BrowseTheWeb.as(actor).find(WELCOME_MESSAGE).getText();
            }
        } else if (type.equals("logIn")) {
            return BrowseTheWeb.as(actor).find(WELCOME_AGAIN_MESSAGE).getText();
        } else {
            return BrowseTheWeb.as(actor).find(LOG_OUT_MESSAGE).getText();
        }
    }

    public static validationThe homePage(){
        return new validationThe(false, "register");
    }

    public static validationThe requiredField(){
        return new validationThe(true, "register");
    }

    public static validationThe ownPage(){
        return new validationThe(false, "logIn");
    }

    public static validationThe logInPage(){
        return new validationThe(false, "logOut");
    }
}
