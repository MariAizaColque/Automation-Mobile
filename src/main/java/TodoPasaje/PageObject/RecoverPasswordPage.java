package TodoPasaje.PageObject;

import TodoPasaje.Common.EventListener;
import TodoPasaje.Common.WaitResult;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static TodoPasaje.Variable.Common.*;

import static TodoPasaje.Locators.RecoverPasswordLocator.*;
/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class RecoverPasswordPage extends EventListener {
    private AppiumDriver<MobileElement> driver;


    @AndroidFindBy(xpath = EMAIL_FIELD)
    private MobileElement emailField;

    @AndroidFindBy(xpath = BTN_RECOVERY)
    private MobileElement btnRecovery;

    @AndroidFindBy(xpath = TOAST_MESSAGE)
    private MobileElement toastMessage;

    public RecoverPasswordPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterEmail(String email) {
        WaitResult.waituntillvisibility(emailField,driver);
        dobleClick(emailField);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        enterText(email);
    }

    public void clickRecoveryPassBtn() {
        WaitResult.waituntillvisibility(btnRecovery,driver);
        click(btnRecovery);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyMessageSend() {
        String message = getText(toastMessage);
        Assert.assertTrue(MESSAGE_RECOVER_ACCOUNT.equalsIgnoreCase(message),"The message is not displayed");
    }
}

