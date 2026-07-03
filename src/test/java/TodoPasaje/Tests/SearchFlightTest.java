package TodoPasaje.Tests;

import TodoPasaje.Config.AndroidBase;
import TodoPasaje.Fill.SearchFlight;
import org.testng.annotations.Test;

/**
 * Created by Maribel on 12/21/2020.
 *
 */
public class SearchFlightTest extends AndroidBase{
    private SearchFlight searchFlight;

//    @Test
//    public void verifyFlightRoundTrip(){
//        searchFlight = new SearchFlight();
//        searchFlight.enterDataRoundTrip();
//    }

    @Test
    public void verifyFlightOneWay(){
        searchFlight = new SearchFlight();
        searchFlight.enterDataOneWay(1,0,0);
        searchFlight.buttonSearchFlight();
    }

    @Test
    public void verifySelectChildrenRoundTrip(){
        searchFlight = new SearchFlight();
        searchFlight.enterDataRoundTrip(1,1,0);
        searchFlight.buttonSearchFlight();
    }

    @Test
    public void verifySelectRoundTrip(){
        searchFlight = new SearchFlight();
        searchFlight.enterDataRoundTrip(1,1,0);
        searchFlight.buttonSearchFlight();
        searchFlight.selectFlightOneWay();
        searchFlight.selectFlightReturn();
    }

    @Test
    public void verifySelectFlightOneWay(){
        searchFlight = new SearchFlight();
        searchFlight.enterDataOneWay(1,0,0);
        searchFlight.buttonSearchFlight();
        searchFlight.selectFlightOneWay();
    }

    @Test
    public void verifySelectChildrenOneWay(){
        searchFlight = new SearchFlight();
        searchFlight.enterDataOneWay(1,1,0);
        searchFlight.buttonSearchFlight();
    }

    @Test
    public void verifySelectInfantRoundTrip(){
        searchFlight = new SearchFlight();
        searchFlight.enterDataRoundTrip(1,1,1);
        searchFlight.buttonSearchFlight();
    }

    @Test
    public void verifySelectInfantOneWay(){
        searchFlight = new SearchFlight();
        searchFlight.enterDataOneWay(1,0,1);
        searchFlight.buttonSearchFlight();
    }
}
