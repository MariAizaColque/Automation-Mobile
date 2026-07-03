package TodoPasaje.Tests;

import TodoPasaje.Config.AndroidBase;
import TodoPasaje.Fill.Login;
import org.testng.annotations.Test;

/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class LoginTest extends AndroidBase{
    private Login login;

    @Test
    public void verifyALogin(){
        login= new Login();
        login.initLogin();
        login.verifyLoginSuccessfully();
    }
    @Test
    public void verifyEmailRequired(){
        login= new Login();
        login.initLogin();
        login.verifyFieldsRequired();
    }
    @Test
    public void verifyLoginWithVisit(){
        login= new Login();
        login.initAsVisit();
        login.verifyCouldEnter();
    }
}
