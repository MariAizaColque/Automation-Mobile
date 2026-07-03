package TodoPasaje.PageObject;

import TodoPasaje.Common.EventListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static TodoPasaje.Locators.SelectFlightLocator.*;
/**
 * Created by Maribel on 12/22/2020.
 *
 */
public class SelectFlightPage extends EventListener {
    private AppiumDriver<MobileElement> driver;

    @AndroidFindBy( uiAutomator = DETALL_FLIGHT)
    private MobileElement btnDetallFlight;

    @AndroidFindBy( accessibility = CHEAPER)
    private MobileElement cheaper;

    @AndroidFindBy( accessibility = FASTER)
    private MobileElement faster;

    @AndroidFindBy( accessibility = FILTERS)
    private MobileElement filters;

    @AndroidFindBy(xpath = LISTFLIGHTS)
    private List<MobileElement> listflights;

    @AndroidFindBy(xpath = FLIGHTONEWAY)
    private MobileElement flightoneway;

    @AndroidFindBy(xpath = FLIGHTRETURN)
    private MobileElement flightreturn;

    @AndroidFindBy(xpath = SELECTONEWAY)
    private MobileElement selectoneway;

    @AndroidFindBy(xpath = DATAPASSENGER)
    private MobileElement datapassenger;

    public SelectFlightPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void clickCheaper(){
        cheaper.click();
    }

    public void clickFaster(){
        faster.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickFilters(){
        filters.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void verifyDetallFlight(){
        isDisplayed(btnDetallFlight);
        String detallFlight = getText(this.btnDetallFlight);
        System.out.println("detallFlight>"+detallFlight);
    }

    public void selectFlightOneWay(){
        getContentDesc(listflights.get(0));
        click(listflights.get(0));
        click(flightoneway);
        click(selectoneway);
    }

    public RegisterPassengerPage clickDataPassenger() {
        click(datapassenger);
        return new RegisterPassengerPage(driver);
    }
}
