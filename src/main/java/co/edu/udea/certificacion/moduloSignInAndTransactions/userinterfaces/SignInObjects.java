package co.edu.udea.certificacion.moduloSignInAndTransactions.userinterfaces;

import net .serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignInObjects {
    public static final Target INPUT_NAME = Target.the("FirstName").located(By.id("customer.firstName"));
    public static final Target INPUT_LASTNAME = Target.the("Lastname").located(By.id("customer.lastName"));
    public static final Target INPUT_ADDRESS = Target.the("Address").located(By.id("customer.address.street"));
    public static final Target INPUT_CITY = Target.the("City").located(By.id("customer.address.city"));
    public static final Target INPUT_STATE = Target.the("State").located(By.id("customer.address.state"));
    public static final Target INPUT_ZIPCODE = Target.the("ZipCode").located(By.id("customer.address.zipCode"));
    public static final Target INPUT_PHONE = Target.the("Phone").located(By.id("customer.phoneNumber"));
    public static final Target INPUT_SSN = Target.the("SSN").located(By.id("customer.ssn"));
    public static final Target INPUT_USERNAME = Target.the("Username").located(By.id("customer.username"));
    public static final Target INPUT_PASSWORD = Target.the("Password").located(By.id("customer.password"));
    public static final Target INPUT_PASSWORD_VERIFICATION = Target.the("PasswordVerification").located(By.id("repeatedPassword"));
    public static final Target BUTTON_SIGN_UP = Target.the("Button").locatedBy("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input");
    public static final Target WELCOME_MESSAGE = Target.the("Message").locatedBy("//*[@id=\"rightPanel\"]/h1");
    public static final Target ERROR_MESSAGE = Target.the("Message").located(By.id("customer.address.city.errors"));
    public static final Target INPUT_USERNAME_LOG_IN = Target.the("Username").locatedBy("//*[@id=\'loginPanel\']/form/div[1]/input");
    public static final Target INPUT_PASSWORD_LOG_IN = Target.the("Password").locatedBy("//*[@id=\'loginPanel\']/form/div[2]/input");
    public static final Target BUTTON_LOG_IN = Target.the("Button").locatedBy("//*[@id=\'loginPanel\']/form/div[3]/input");
    public static final Target BUTTON_LOG_OUT = Target.the("Button").locatedBy("//*[@id=\"leftPanel\"]/ul/li[8]/a");
    public static final Target WELCOME_AGAIN_MESSAGE = Target.the("Button").locatedBy("//*[@id=\"showOverview\"]/h1");
    public static final Target LOG_OUT_MESSAGE = Target.the("Button").locatedBy("//*[@id=\"leftPanel\"]/h2");

;}