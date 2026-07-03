package TodoPasaje.PageObject;

import TodoPasaje.Common.EventListener;
import TodoPasaje.Common.Schedule;
import TodoPasaje.Common.WaitResult;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static TodoPasaje.Locators.CommonElements.BTN_CONTINUE;
import static TodoPasaje.Locators.CommonElements.COME_BACK;
import static TodoPasaje.Locators.SearchFlightLocator.*;

/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class SearchFlightPage extends EventListener{
    private AppiumDriver<MobileElement> driver;
    private String originValue;
    private String destinyValue;
    private Schedule schedule;

    @AndroidFindBy(accessibility = FLIGHT_ONEWAY)
    private MobileElement flightOneWay;

    @AndroidFindBy(accessibility = FLIGHT_ROUNDTRIP)
    private MobileElement flightRoundTrip;

    @AndroidFindBy(xpath = LIST_COUNTRY_NAME)
    private List<MobileElement> listCountry;

    @AndroidFindBy(accessibility = FIELD_ORIGIN)
    private MobileElement originField;

    @AndroidFindBy(accessibility = FIELD_DESTINY)
    private MobileElement destinyField;

    @AndroidFindBy(className = TEXT_ROUTE)
    private MobileElement routeText;

    @AndroidFindBy(className = LIST_ROUTE)
    private List<MobileElement> listRoute;

    @AndroidFindBy(accessibility = PICKER_DATE)
    private MobileElement pickerDate;

    @AndroidFindBy(accessibility = PICKER_DATES)
    private MobileElement pickerDates;

    @AndroidFindBy(xpath = COUNT_PAXS)
    private MobileElement countPax;

    @AndroidFindBy(xpath = BTN_CONTINUE)
    private MobileElement btnContinue;

    @AndroidFindBy(xpath = BTN_SEARCH_FLIGHT)
    private MobileElement btnSearchFlight;

    @AndroidFindBy(xpath = VALUE_ORIGIN)
    private MobileElement valueOriginElement;

    @AndroidFindBy(xpath = VALUE_DESTINY)
    private MobileElement valueDestinyElement;

    @AndroidFindBy(xpath = VALUE_DATE)
    private MobileElement valueDateElement;

    @AndroidFindBy(accessibility = COUNTRY)
    private MobileElement country;

    @AndroidFindBy(xpath = NEXT_MONTH)
    private MobileElement nextMonth;

    @AndroidFindBy(xpath = COME_BACK)
    private MobileElement btnComeback;

    @AndroidFindBy(xpath = TOAST_MESSAGE)
    private MobileElement toastMessage;

    @AndroidFindBy(xpath = BTN_FLIGHT)
    private MobileElement btnFlight;



    private ArrayList<String> resultOrder;

    public SearchFlightPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickFlights(){
        click(btnFlight);
    }

    public void isDisplayedFlights( ) {
        Assert.assertTrue(isDisplayed(btnFlight),"The icon is not displayed");

    }

    public void enterRoute(String routeCityCbb, String routeCityLpb) {
        enterOrigin(routeCityCbb);
        enterDestiny(routeCityLpb);
    }

    private void enterOrigin(String routeCityCbb) {
        WaitResult.waituntillvisibility(originField,driver);
        click(originField);
        driver.findElement(MobileBy.AndroidUIAutomator(String.format(LIST_ROUTE_CITY,routeCityCbb))).click();
        originValue = routeCityCbb;
    }

    private void enterDestiny(String routeCityLpb) {
        WaitResult.waituntillvisibility(destinyField,driver);
        click(destinyField);
        driver.findElement(MobileBy.AndroidUIAutomator(String.format(LIST_ROUTE_CITY,routeCityLpb))).click();
        destinyValue = routeCityLpb;
    }

    public void selectDateRoundTrip(String dateOneway, String dateReturned) {
        enterDate(dateOneway,"pickerDates");
        enterDateReturned(dateReturned);
    }

    private void enterDateReturned(String dateReturned) {
        String[] parts = dateReturned.split(" ");
        String day = parts[0];
        String months = parts[1];
        int yearCurrent = schedule.currentYear(Calendar.getInstance());
        String monthCurrent = schedule.currentMonth(Calendar.getInstance());
        driver.findElementByXPath(getXPathMonth(yearCurrent,monthCurrent,day,months)).click();
    }

    public void selectDateOneWay(String dateOneway) {
        enterDate(dateOneway,"pickerDate");
    }

    private void enterDate(String date,String picker){
        schedule = new Schedule();
        clickPicker(picker);
        String[] parts = date.split(" ");
        String day = parts[0];
        String months = parts[1];
        int yearCurrent = schedule.currentYear(Calendar.getInstance());
        String monthCurrent = schedule.currentMonth(Calendar.getInstance());
        driver.findElementByXPath(getXPathMonth(yearCurrent,monthCurrent,day,months)).click();
    }

    private void clickPicker(String picker) {
        if(picker.equals("pickerDate")){
            click(pickerDate);
        }else{
            if(picker.equals("pickerDates")){
                click(pickerDates);
            }
        }
    }

    private String getXPathMonth(int yearCurrent, String monthCurrent, String dayExpected, String monthExpected) {
        boolean flag = false;
        String current = null;
        while (flag == false){
            if(monthCurrent.equalsIgnoreCase(monthExpected)){
                current = String.format(DAY,monthCurrent + " " +dayExpected +", " + yearCurrent );
                flag = true;
            } else{
                String next = getContentDesc(nextMonth);
                String [] nextMonthPart = next.split(" ");
                yearCurrent = Integer.valueOf(nextMonthPart[nextMonthPart.length-1]);
                monthCurrent = nextMonthPart[nextMonthPart.length-2];
                click(nextMonth);
            }
        }
        return current;
    }

    public void clickContinueButton(){
        click(btnContinue);
    }

    public SelectFlightPage clickSearchFlight(){
        WaitResult.waituntillvisibility(btnSearchFlight,driver);
        click(btnSearchFlight);
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SelectFlightPage(driver);
    }

    public void clickFlightOW(){
        click(flightOneWay);
    }

    public void clickFlightRT(){
        click(flightRoundTrip);
    }

    public TypePaxFarePage clickPaxs() {
        click(countPax);
        return new TypePaxFarePage(driver);
    }
}
