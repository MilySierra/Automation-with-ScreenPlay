package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

@RequiredArgsConstructor
public class OpenThe implements Task {

    private final String page;

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (page.equals("register")){
            actor.attemptsTo(Open.browserOn().thePageNamed("pages.paraBankRegisterUrl"));
            Wait.waitSomeMills(3000);
        } else if (page.equals("logIn")){
            actor.attemptsTo(Open.browserOn().thePageNamed("pages.paraBankLogInUrl"));
            Wait.waitSomeMills(3000);
        } else if (page.equals("home")){
            actor.attemptsTo(Open.browserOn().thePageNamed("pages.paraBankHomeUrl"));
            Wait.waitSomeMills(3000);
        }
    }

    public static OpenThe browser(){
        return Tasks.instrumented(OpenThe.class, "register");
    }

    public static OpenThe logInBrowser(){
        return Tasks.instrumented(OpenThe.class, "logIn");
    }

    public static OpenThe homePage(){
        return Tasks.instrumented(OpenThe.class, "home");
    }


}
