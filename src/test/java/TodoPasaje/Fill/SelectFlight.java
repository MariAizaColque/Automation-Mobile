package TodoPasaje.Fill;

import TodoPasaje.Config.AndroidBase;
import TodoPasaje.PageObject.RegisterPassengerPage;
import TodoPasaje.PageObject.SelectFlightPage;

/**
 * Created by Maribel on 12/22/2020.
 *
 */
public class SelectFlight extends AndroidBase{
    private SelectFlightPage selectFlightPage;
    private SearchFlight searchFlight;

    public SelectFlight() {
        searchFlight = new SearchFlight();
        searchFlight.enterDataOneWay(1,0,0);
        selectFlightPage=searchFlight.buttonSearchFlight();

    }
    public void selectFlightCheaper(){
        selectFlightPage.clickCheaper();
    }

    public void selectFlightFaster(){
        selectFlightPage.clickFaster();
        selectFlightPage.verifyDetallFlight();
        selectFlightPage.selectFlightOneWay();
    }

    public void selectFlightFilters(){
        selectFlightPage.clickFilters();
    }

    public RegisterPassengerPage clickRegisterPax(){
        return selectFlightPage.clickDataPassenger();
    }
}
