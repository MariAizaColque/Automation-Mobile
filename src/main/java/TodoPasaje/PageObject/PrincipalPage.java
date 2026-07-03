package TodoPasaje.PageObject;

import TodoPasaje.Common.EventListener;
import TodoPasaje.Common.WaitResult;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;
import static TodoPasaje.Locators.PrincipalLocator.*;
/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class PrincipalPage extends EventListener{
    AppiumDriver<MobileElement> driver;

    @AndroidFindBy(xpath = BTN_VISITOR)
    private MobileElement btnVisitor;

    @AndroidFindBy(xpath = BTN_CREATE_SIGNING)
    private MobileElement btnCreateSigning;

    @AndroidFindBy(accessibility = APPLICATION_NAME)
    private MobileElement nameApp;

    public PrincipalPage(AppiumDriver<MobileElement>  driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public SearchFlightPage clickEnterAsVisit(){
        WaitResult.waituntillvisibility(btnVisitor,driver);
        click(btnVisitor);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SearchFlightPage(driver);
    }

    public LoginPage clickLoginPage(){
        clickBtnCreateLogin();
        return new LoginPage(driver);
    }

    public void clickBtnCreateLogin(){
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
        WaitResult.waituntillvisibility(btnCreateSigning,driver);
        click(btnCreateSigning);
    }
}
