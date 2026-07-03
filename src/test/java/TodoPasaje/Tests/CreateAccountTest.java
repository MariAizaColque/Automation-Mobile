package TodoPasaje.Tests;

import TodoPasaje.Config.AndroidBase;
import TodoPasaje.Fill.CreateAccount;
import org.testng.annotations.Test;

/**
 * Created by Maribel on 12/21/2020.
 *
 */
public class CreateAccountTest extends AndroidBase{
    private CreateAccount createAccount;

    @Test
    public void verifyAccountASuccessfulCreation(){
        createAccount = new CreateAccount();
        createAccount.enterNewUser();
        createAccount.verifySuccessAccount();
    }

    @Test
    public void verifyAccountCreated(){
        createAccount = new CreateAccount();
        createAccount.enterUserSaved();
        createAccount.verifyMessageWarning();
    }

    @Test
    public void verifyEmailRequired(){
        createAccount = new CreateAccount();
        createAccount.verifyFieldsRequired();
    }
}
