package co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransactionObjects {
    public static final Target INPUT_AMOUNT_LOAN = Target.the("Amount").located(By.id("amount"));
    public static final Target INPUT_DOWN_LOAN = Target.the("Down").located(By.id("downPayment"));
    public static final Target BUTTON_LOAN = Target.the("Button").locatedBy("//*[@id=\"requestLoanForm\"]/form/table/tbody/tr[4]/td[2]/input");
    public static final Target INPUT_FROM_ACCOUNT_LOAN = Target.the("FromAccount").located(By.id("fromAccountId"));
    public static final Target ERROR_MESSAGE_LOAN = Target.the("Error message").locatedBy("//*[@id=\"requestLoanError\"]/h1");
    public static final Target MESSAGE_LOIN = Target.the("Message").locatedBy("//*[@id=\"requestLoanResult\"]/h1");


}
