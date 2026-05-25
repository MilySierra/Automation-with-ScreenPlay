package co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class AccountObjects {

    public static final Target OPEN_NEW_ACCOUNT_LINK = Target.the("Open New Account link")
            .locatedBy("//a[contains(text(),'Open New Account')]");

    public static final Target ACCOUNT_TYPE_DROPDOWN = Target.the("Account type dropdown")
            .locatedBy("//*[@id='type']");

    public static final Target FROM_ACCOUNT_DROPDOWN = Target.the("From account dropdown")
            .locatedBy("//*[@id='fromAccountId']");

    public static final Target OPEN_ACCOUNT_BUTTON = Target.the("Open New Account button")
            .locatedBy("//input[@type='button'][@value='Open New Account']");

    public static final Target CONFIRMATION_MESSAGE = Target.the("Confirmation message")
            .locatedBy("//*[@id='openAccountResult']/h1[@class='title']");
}