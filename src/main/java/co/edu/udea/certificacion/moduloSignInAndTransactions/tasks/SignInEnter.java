package co.edu.udea.certificacion.moduloSignInAndTransactions.tasks;

import co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.logIn;
import co.edu.udea.certificacion.moduloSignInAndTransactions.interactions.signUp;
import co.edu.udea.certificacion.moduloSignInAndTransactions.utils.Wait;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

@RequiredArgsConstructor
public class SignInEnter implements Task {

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

    public static SignInEnter information(){
        return Tasks.instrumented(SignInEnter.class, false, "information");
    }

    public static SignInEnter informationIncomplete(){
        return Tasks.instrumented(SignInEnter.class, true, "information");
    }

    public static SignInEnter credentials(){
        return Tasks.instrumented(SignInEnter.class, false, "credentials");
    }
}
