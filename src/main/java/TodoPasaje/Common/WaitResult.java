package TodoPasaje.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class WaitResult {
    private static WebDriverWait wait;
    public static void waituntillvisibility(MobileElement element, AppiumDriver<MobileElement> driver) {
        wait = new WebDriverWait(driver, 90); //360
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
