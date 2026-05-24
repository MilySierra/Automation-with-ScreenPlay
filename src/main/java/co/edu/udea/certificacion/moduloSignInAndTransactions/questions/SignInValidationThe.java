package co.edu.udea.certificacion.moduloSignInAndTransactions.questions;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.SignInObjects.*;

@RequiredArgsConstructor
public class SignInValidationThe implements Question<String> {

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

    public static SignInValidationThe homePage(){
        return new SignInValidationThe(false, "register");
    }

    public static SignInValidationThe requiredField(){
        return new SignInValidationThe(true, "register");
    }

    public static SignInValidationThe ownPage(){
        return new SignInValidationThe(false, "logIn");
    }

    public static SignInValidationThe logInPage(){
        return new SignInValidationThe(false, "logOut");
    }
}
