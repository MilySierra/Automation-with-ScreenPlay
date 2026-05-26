package co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ViewObjects {

    public static final Target ACCOUNT = Target.the("Account").located(By.id("newAccountId"));

    public static Target ACCOUNT_LINK(String accountId) {
        return Target.the("account link")
                .located(By.xpath("//a[normalize-space(.)='" + accountId + "' and contains(@href,'activity.htm?id=" + accountId + "')]"));
    }

    public static final Target MESSAGE_ACCOUNT = Target.the("Account").locatedBy("//*[@id=\"accountDetails\"]/h1");
    public static Target DEFAULT_ACCOUNT_LINK = Target.the("First account").located(By.xpath("(//a[contains(@href,'activity.htm')])[1]"));
}
