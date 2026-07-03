package TodoPasaje.Common;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import TodoPasaje.PageObject.PrincipalPage;
import static TodoPasaje.Variable.General.principalPage;
/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class Process {

    private AndroidDriver<MobileElement> driver;

    public Process(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void principalView() {
        if (principalPage == null) {
            principalPage = new PrincipalPage(driver);
        }
    }

    public PrincipalPage getPrincipal() {
        return principalPage;
    }

}
