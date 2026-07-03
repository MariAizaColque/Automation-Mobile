package TodoPasaje.Tests;

import TodoPasaje.Config.AndroidBase;
import TodoPasaje.Fill.SelectFlight;
import org.testng.annotations.Test;

/**
 * Created by Maribel on 12/22/2020.
 *
 */
public class SelectFlightTest extends AndroidBase{
    private SelectFlight searchFlight;

//    @Test
//    public void verifyFlightOneWayCheaper(){
//        searchFlight = new SelectFlight();
//        searchFlight.selectFlightCheaper();
//    }
    @Test
    public void verifyFlightOneWayFaster(){
        searchFlight = new SelectFlight();
        searchFlight.selectFlightFaster();
    }
    @Test
    public void verifyFlightOneWayFilters(){
        searchFlight = new SelectFlight();
        searchFlight.selectFlightFilters();
    }
}
