package TodoPasaje.Config;

import TodoPasaje.Variable.General;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import TodoPasaje.Common.Process;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maribel on 12/1/2020.
 *
 */

@SuppressWarnings("unchecked")
public class AndroidBase {

    public static Process process;
    @BeforeMethod
    public void setupCommounMethod(){
        process = new Process(General.driver);

    }
    @AfterMethod
    public void restartApp(){
        General.driver.resetApp();
    }

    @BeforeSuite
    public void setUpAppium(){
        DesiredCapabilities clientCapabilities = new DesiredCapabilities();

        String path = System.getProperty("user.dir");
        clientCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel9");
        clientCapabilities.setCapability(MobileCapabilityType.APP, path +"\\src\\test\\resources\\release.apk");
        clientCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        try {
            General.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), clientCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        General.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tear(){
        General.driver.quit();
    }

}
