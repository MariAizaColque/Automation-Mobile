package TodoPasaje.Tests;

import TodoPasaje.Config.AndroidBase;
import TodoPasaje.Fill.RegisterPassenger;
import org.testng.annotations.Test;

/**
 * Created by Maribel on 1/7/2021.
 *
 */
public class RegisterPassengerTest extends AndroidBase{
    private RegisterPassenger registerPassenger;

    @Test
    public void verifyPassenger(){
        registerPassenger = new RegisterPassenger();
        registerPassenger.enterData();
    }
}
