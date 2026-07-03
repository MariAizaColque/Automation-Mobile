package TodoPasaje.PageObject;

import TodoPasaje.Common.EventListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import static TodoPasaje.Locators.CreateUserLocator.*;
import static TodoPasaje.Variable.Common.*;

/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class CreateUserPage extends EventListener{
    private AppiumDriver<MobileElement> driver;

    @AndroidFindBy(xpath = TEXT_EMAIL)
    private MobileElement textEmail;

    @AndroidFindBy(xpath = TEXT_PASSWORD)
    private MobileElement textPassword;

    @AndroidFindBy(xpath = TEXT_REPEAT_PASSWORD)
    private MobileElement textRepeatPass;

    @AndroidFindBy(xpath = BTN_SIGNIN)
    private MobileElement btnSignIn;

    @AndroidFindBy(xpath = BTN_CREATE_ACCOUNT)
    private MobileElement btnCreateAccount;

    @AndroidFindBy(xpath = TOAST_MESSAGE)
    private MobileElement toastMessage;

    @AndroidFindBy(accessibility = FIELD_REQUIRED)
    private MobileElement fieldRequired;

    public CreateUserPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
    }


    public void enterEmail(String value){
        dobleClick(textEmail);
        enterText(value);
    }

    public void enterPassword(String value){
        dobleClick(textPassword);
        enterText(value);
    }

    public void enterConfirmPassword(String password){
        dobleClick(textRepeatPass);
        enterText(password);
    }

    public void registerUser(String username, String password) {
        enterEmail(username);
        enterPassword(password);
        enterConfirmPassword(password);
        driver.navigate().back();
        clickCreateAccount();

    }

    public void clickCreateAccount(){

        click(btnCreateAccount);
    }

    public void verifyMessageSuccess() {
        String message = toastMessage.getText();
        Assert.assertTrue(MESSAGE_NEW_ACCOUNT.equalsIgnoreCase(message),"The message is not displayed");
    }

    public void verifyMessageWarning() {
        String message = toastMessage.getText();
        System.out.println("mensaje de advertencia>"+message);
        Assert.assertTrue(MESSAGE_WARNING_ACCOUNT.equalsIgnoreCase(message),"The message is not displayed");
    }
    public void verifyFieldRequired(){
        clickCreateAccount();
        Assert.assertTrue(isDisplayed(fieldRequired),"The message is not displayed");

    }
}
