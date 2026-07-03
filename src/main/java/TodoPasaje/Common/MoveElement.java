package TodoPasaje.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Dimension;

/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class MoveElement {
    public TouchAction touchAction;
    public  int x, starY, endY;
    public Dimension size;
    public int sizeYMedium,Xend;
    protected AppiumDriver<MobileElement> driver;

    public MoveElement(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public  void defineDimension(){
        size = driver.manage().window().getSize();
        x = size.getWidth()/2;
        starY = (int)(size.getHeight()*0.60);
        endY = (int)(size.getHeight()*0.10);
    }
    public void touchActionMoveElement(MobileElement origin, MobileElement destinyElement){
        touchAction = new TouchAction(driver);
        touchAction.longPress(ElementOption.element(destinyElement)).moveTo(ElementOption.element(origin)).release().perform();
    }

}
