package TodoPasaje.Fill;

import TodoPasaje.Config.AndroidBase;
import TodoPasaje.PageObject.SearchFlightPage;
import TodoPasaje.PageObject.SelectFlightPage;
import TodoPasaje.PageObject.TypePaxFarePage;
import TodoPasaje.Variable.Common;

/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class SearchFlight extends AndroidBase {
    private SearchFlightPage searchFlightPage;
    private TypePaxFarePage typePaxFarePage;

    public SearchFlight() {
        process.principalView();
        searchFlightPage = process.getPrincipal().clickEnterAsVisit();
        searchFlightPage.clickFlights();
    }

    public void enterDataRoundTrip(int adults, int children, int infants) {
        searchFlightPage.clickFlightRT();
        searchFlightPage.enterRoute(Common.ROUTE_CITY_CBB,Common.ROUTE_CITY_LPB);
        searchFlightPage.selectDateRoundTrip(Common.DATE_ONEWAY,Common.DATE_RETURNED);
        typePaxFarePage = searchFlightPage.clickPaxs();
        typePaxFarePage.selectEconomic(adults,children,infants);
        searchFlightPage.clickContinueButton();
    }

    public void enterDataOneWay(int adults, int children, int infants) {
        searchFlightPage.clickFlightOW();
        searchFlightPage.enterRoute(Common.ROUTE_CITY_CBB,Common.ROUTE_CITY_LPB);
        searchFlightPage.selectDateOneWay(Common.DATE_ONEWAY);
        typePaxFarePage = searchFlightPage.clickPaxs();
        typePaxFarePage.selectEconomic(adults,children,infants);
        searchFlightPage.clickContinueButton();
    }
    public SelectFlightPage buttonSearchFlight(){
        return searchFlightPage.clickSearchFlight();
    }

    public void selectFlightOneWay() {


    }

    public void selectFlightReturn() {
    }
}
