package TodoPasaje.Tests;

import TodoPasaje.Config.AndroidBase;
import TodoPasaje.Fill.RecoverAccount;
import org.testng.annotations.Test;

/**
 * Created by Maribel on 12/18/2020.
 *
 */
public class RecoverAccountTest extends AndroidBase{
    private RecoverAccount recoverAccount;

    @Test
    public void verifySendEmail(){
        recoverAccount = new RecoverAccount();
        recoverAccount.sendEmail();
    }
}
