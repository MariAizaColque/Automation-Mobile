package TodoPasaje.Fill;

import TodoPasaje.Config.AndroidBase;
import TodoPasaje.PageObject.RegisterPassengerPage;

/**
 * Created by Maribel on 1/7/2021.
 *
 */
public class RegisterPassenger extends AndroidBase{
    private SelectFlight selectFlight;
    private RegisterPassengerPage registerPassengerPage;

    public RegisterPassenger() {
        selectFlight = new SelectFlight();
        selectFlight.selectFlightFaster();
        registerPassengerPage = selectFlight.clickRegisterPax();
    }

    public void enterData() {

    }
}
