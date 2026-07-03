package TodoPasaje.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class EventListener {

    protected AppiumDriver<MobileElement> driver;
    public MoveElement moveElement;

    public EventListener(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        moveElement = new MoveElement(driver);
    }

    public void click(MobileElement element){
        element.click();
    }

    public void dobleClick(MobileElement element){
        click(element);
        click(element);
    }

    public void enterText(String value){
        Actions action = new Actions(driver);
        action.sendKeys(value).build().perform();
    }

    public String  getContentDesc(MobileElement element){
        return element.getAttribute("content-desc");
    }

    public String getText(MobileElement element){
        return element.getText();
    }

    public boolean isDisplayed(MobileElement element){
        return element.isDisplayed();
    }
}
