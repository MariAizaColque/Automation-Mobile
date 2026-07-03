package TodoPasaje.Fill;

import TodoPasaje.Config.AndroidBase;
import TodoPasaje.PageObject.LoginPage;
import TodoPasaje.PageObject.RecoverPasswordPage;
import TodoPasaje.Variable.Common;

/**
 * Created by Maribel on 12/18/2020.
 *
 */
public class RecoverAccount extends AndroidBase{
    private RecoverPasswordPage recoverPasswordPage;
    private LoginPage loginPage;

    public RecoverAccount( ) {
        process.principalView();
        loginPage = process.getPrincipal().clickLoginPage();
        loginPage.verifyRecoverPassword();
        recoverPasswordPage = loginPage.clickForgotPassword();
    }

    public void sendEmail() {
        recoverPasswordPage.enterEmail(Common.RECOVER_USER);
        recoverPasswordPage.clickRecoveryPassBtn();
        recoverPasswordPage.verifyMessageSend();
    }
}
