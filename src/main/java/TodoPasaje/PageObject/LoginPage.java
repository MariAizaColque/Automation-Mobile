package TodoPasaje.PageObject;

import TodoPasaje.Common.EventListener;
import TodoPasaje.Common.WaitResult;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static TodoPasaje.Locators.LoginLocator.*;

/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class LoginPage extends EventListener{
    private AppiumDriver<MobileElement> driver;
    private CreateUserPage user;

    @AndroidFindBy(xpath = TEXT_EMAIL)
    private MobileElement textEmail;

    @AndroidFindBy(xpath = TEXT_PASSWORD)
    private MobileElement textPassword;

    @AndroidFindBy(xpath = BTN_SIGNIN)
    private MobileElement btnSignIn;

    @AndroidFindBy(xpath = BTN_CREATE_ACCOUNT)
    private MobileElement btnCreateAccount;

    @AndroidFindBy(accessibility = LINK_FORGOT)
    private MobileElement linkForgot;

    @AndroidFindBy(xpath = TITLE_LOGIN)
    private MobileElement titleLogin;

    @AndroidFindBy(xpath = BTN_FLIGHT)
    private MobileElement btnFlight;

    @AndroidFindBy(xpath = TOAST_MESSAGE)
    private MobileElement toastMessage;

    @AndroidFindBy(accessibility = FIELD_REQUIRED)
    private MobileElement fieldRequired;

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        user = new CreateUserPage(driver);
    }

    public void enterEmail(String value){
        dobleClick(textEmail);
        enterText(value);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickSignIn();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void enterPassword(String value){
        dobleClick(textPassword);
        enterText(value);
    }

    private void clickSignIn(){
        click(btnSignIn);
    }

    public boolean verifyLoginSuccessfully() {
        return isDisplayed(btnFlight);
    }

    public void enterAsVisit() {

    }

    public boolean verifyRecoverPassword() {
        return isDisplayed(linkForgot);
    }

    public RecoverPasswordPage clickForgotPassword(){
        WaitResult.waituntillvisibility(linkForgot,driver);
        click(linkForgot);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new RecoverPasswordPage(driver);
    }

    public CreateUserPage clickRegisterAccount() {
        click(btnCreateAccount);
        return new CreateUserPage(driver);
    }

    public void verifyFieldRequired() {
        clickSignIn();
        Assert.assertTrue(isDisplayed(fieldRequired),"The message is not displayed");
    }
}
