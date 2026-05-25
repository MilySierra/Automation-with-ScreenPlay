package co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UpdateObjects {
    public static final Target UPDATE_PROFILE_LINK = Target.the("Update link").locatedBy("//*[@id=\"leftPanel\"]/ul/li[6]/a");
    public static final Target INPUT_USER_ADDRESS = Target.the("Address text").located(By.id("customer.address.street"));
    public static final Target INPUT_USER_CITY = Target.the("City text").located(By.id("customer.address.city"));
    public static final Target INPUT_USER_STATE = Target.the("State text").located(By.id("customer.address.state"));
    public static final Target INPUT_USER_ZIP = Target.the("Zip text").located(By.id("customer.address.zipCode"));
    public static final Target UPDATE_PROFILE_BUTTON = Target.the("Update button").locatedBy("//*[@id=\"updateProfileForm\"]/form/table/tbody/tr[8]/td[2]/input");
    public static final Target PROFILE_UPDATED_MESSAGE = Target.the("Profile updated message").locatedBy("//*[@id=\"updateProfileResult\"]/h1");
    public static final Target EMPTY_FIELD = Target.the("Empty field message").locatedBy("//*[@id='city-error']");
}
