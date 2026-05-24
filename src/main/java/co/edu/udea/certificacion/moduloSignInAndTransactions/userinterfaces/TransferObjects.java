package co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransferObjects {
    public static final Target INPUT_AMOUNT = Target.the("Amount").located(By.id("amount"));
    public static final Target INPUT_FROM_ACCOUNT = Target.the("FromAccount").located(By.id("fromAccountId"));
    public static final Target INPUT_TO_ACCOUNT = Target.the("ToAccount").located(By.id("toAccountId"));
    public static final Target BUTTON_TRANSFER = Target.the("Button").locatedBy("//*[@id=\"transferForm\"]/div[2]/input");
    public static final Target MESSAGE = Target.the("Message").locatedBy("//*[@id=\"showResult\"]/h1");
    public static final Target ERROR_MESSAGE = Target.the("ErrorMessage").locatedBy("//*[@id=\"showError\"]/h1");

}
