package co.edu.udea.certificacion.moduloSignInAndTransactions.questions;

import co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.UpdateObjects;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

import static co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces.UpdateObjects.*;


@RequiredArgsConstructor
public class UpdateValidationThe implements Question<Boolean> {

    private final String type;

    @Override
    public Boolean answeredBy(Actor actor) {
        if (type.equals("updated")) {
            return BrowseTheWeb.as(actor).find(PROFILE_UPDATED_MESSAGE)
                    .getText().equals("Profile Updated");
        } else {
            return BrowseTheWeb.as(actor).find(EMPTY_FIELD)
                    .getText().equals("City is required.");
        }
    }

    public static UpdateValidationThe updatePage() {
        return new UpdateValidationThe("updated");
    }

    public static UpdateValidationThe updatePageWithError() {
        return new UpdateValidationThe("error");
    }
}