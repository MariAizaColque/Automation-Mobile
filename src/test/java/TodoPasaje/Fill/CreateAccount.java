package TodoPasaje.Fill;

import TodoPasaje.Common.TestMath;
import TodoPasaje.Config.AndroidBase;
import TodoPasaje.PageObject.CreateUserPage;
import TodoPasaje.PageObject.LoginPage;

import static TodoPasaje.Variable.Common.*;

/**
 * Created by Maribel on 12/21/2020.
 *
 */
public class CreateAccount extends AndroidBase{
    private LoginPage loginPage;
    private CreateUserPage createUserPage;

    public CreateAccount() {
        process.principalView();
        loginPage = process.getPrincipal().clickLoginPage();
        createUserPage = loginPage.clickRegisterAccount();
    }

    public void enterNewUser(){
        String login =TestMath.generateUser();
        NEW_USERNAME=login;
        createUserPage.registerUser(login,PASSWORD_NEW);
    }

    public void verifySuccessAccount() {
        createUserPage.verifyMessageSuccess();
    }

    public void enterUserSaved() {
        System.out.println("NEW_USERNAME>"+NEW_USERNAME);
        createUserPage.registerUser(NEW_USERNAME,PASSWORD_NEW);
    }

    public void verifyMessageWarning() {
        createUserPage.verifyMessageWarning();
    }

    public void verifyFieldsRequired(){
        createUserPage.verifyFieldRequired();
    }
}
