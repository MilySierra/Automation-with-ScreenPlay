package co.edu.udea.certificacion.moduloSignInAndTransactions.interactions;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.SignInObjects.*;

@RequiredArgsConstructor
public class signUp implements Interaction {

    public static final String FIRSTNAME = "Daniella";
    public static final String LASTNAME = "Taborda";
    public static final String ADDRESS = "carrera 34";
    public static final String STATE = "Japon";
    public static final String ZIPCODE = "329";
    public static final String PHONE = "2345678908";
    public static final String SSN = "68";
    public static final String USERNAME = "dani" + (int)(Math.random() * 99);;
    public static final String PASSWORD = "dani987!";
    public static final String PASSWORD_VERIFICATION = "dani987!";
    public final String CITY;


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(FIRSTNAME).into(INPUT_NAME));
        actor.attemptsTo(Enter.theValue(LASTNAME).into(INPUT_LASTNAME));
        actor.attemptsTo(Enter.theValue(ADDRESS).into(INPUT_ADDRESS));
        actor.attemptsTo(Enter.theValue(CITY).into(INPUT_CITY));
        actor.attemptsTo(Enter.theValue(STATE).into(INPUT_STATE));
        actor.attemptsTo(Enter.theValue(ZIPCODE).into(INPUT_ZIPCODE));
        actor.attemptsTo(Enter.theValue(PHONE).into(INPUT_PHONE));
        actor.attemptsTo(Enter.theValue(SSN).into(INPUT_SSN));
        actor.attemptsTo(Enter.theValue(USERNAME).into(INPUT_USERNAME));
        actor.attemptsTo(Enter.theValue(PASSWORD).into(INPUT_PASSWORD));
        actor.attemptsTo(Enter.theValue(PASSWORD_VERIFICATION).into(INPUT_PASSWORD_VERIFICATION));
        actor.attemptsTo(Click.on(BUTTON_SIGN_UP));
    }

    public static signUp user (){
        return Tasks.instrumented(signUp.class, "Tokyo");
    }

    public static signUp userWithIncompleteInformation (){
        return Tasks.instrumented(signUp.class, "");
    }
}