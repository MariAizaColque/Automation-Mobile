package TodoPasaje.Fill;

import TodoPasaje.Config.AndroidBase;
import TodoPasaje.PageObject.LoginPage;
import TodoPasaje.PageObject.SearchFlightPage;
import TodoPasaje.Variable.Common;
import org.testng.Assert;

/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class Login extends AndroidBase {
    private LoginPage loginPage;
    private SearchFlightPage searchFlightPage;

    public Login(){
        process.principalView();
    }

    public void initLogin(){
        loginPage = process.getPrincipal().clickLoginPage();
    }

    public void verifyLoginSuccessfully() {
        loginPage.login(Common.USERNAME,Common.PASSWORD);
        Assert.assertTrue(loginPage.verifyLoginSuccessfully());
    }

    public void initAsVisit(){
        searchFlightPage = process.getPrincipal().clickEnterAsVisit();
    }

    public void verifyFieldsRequired() {
        loginPage.verifyFieldRequired();
    }

    public void verifyCouldEnter() {
        searchFlightPage.isDisplayedFlights();
    }
}
