package co.edu.udea.certificacion.moduloSignInAndTransactions.interactions;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.UpdateObjects.*;

@RequiredArgsConstructor
public class updateInformation implements Interaction {

    public static final String NEW_ADDRESS = "Carrera 40";
    public static final String NEW_STATE = "Antioquia";
    public static final String NEW_ZIPCODE = "285";
    public final String CITY;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(UPDATE_PROFILE_LINK));
        actor.attemptsTo(Clear.field(INPUT_USER_ADDRESS));
        actor.attemptsTo(Enter.theValue(NEW_ADDRESS).into(INPUT_USER_ADDRESS));
        actor.attemptsTo(Clear.field(INPUT_USER_CITY));
        actor.attemptsTo(Enter.theValue(CITY).into(INPUT_USER_CITY));
        actor.attemptsTo(Clear.field(INPUT_USER_STATE));
        actor.attemptsTo(Enter.theValue(NEW_STATE).into(INPUT_USER_STATE));
        actor.attemptsTo(Clear.field(INPUT_USER_ZIP));
        actor.attemptsTo(Enter.theValue(NEW_ZIPCODE).into(INPUT_USER_ZIP));
        actor.attemptsTo(Click.on(UPDATE_PROFILE_BUTTON));
    }

    public static updateInformation user() {
        return Tasks.instrumented(updateInformation.class, "Medellin");
    }

    public static updateInformation updateWithEmptyField() {
        return Tasks.instrumented(updateInformation.class, "");
    }
}