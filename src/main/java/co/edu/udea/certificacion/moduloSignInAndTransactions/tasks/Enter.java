package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.logIn;
import co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.signUp;
import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

@RequiredArgsConstructor
public class Enter implements Task {

    private final boolean incomplete;
    private final String type;

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (type.equals("information")){
            if (incomplete){
                actor.attemptsTo(signUp.userWithIncompleteInformation());
                Wait.waitSomeMills(5000);
            }
            else{
                actor.attemptsTo(signUp.user());
                Wait.waitSomeMills(5000);
            }
        } else {
            actor.attemptsTo(logIn.user());
            Wait.waitSomeMills(5000);
        }
    }

    public static Enter information(){
        return Tasks.instrumented(Enter.class, false, "information");
    }

    public static Enter informationIncomplete(){
        return Tasks.instrumented(Enter.class, true, "information");
    }

    public static Enter credentials(){
        return Tasks.instrumented(Enter.class, false, "credentials");
    }
}
