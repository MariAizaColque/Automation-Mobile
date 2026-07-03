package TodoPasaje.PageObject;

import TodoPasaje.Common.EventListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static TodoPasaje.Locators.RegisterPassengerLocator.*;

/**
 * Created by Maribel on 1/7/2021.
 *
 */
public class RegisterPassengerPage extends EventListener{
    private AppiumDriver<MobileElement> driver;

    @AndroidFindBy(xpath = LISTPAX)
    private List<MobileElement> listPax;

    @AndroidFindBy(xpath = CHECKBOXPAX)
    private MobileElement checkboxpax;

    @AndroidFindBy(xpath = EMAIL)
    private MobileElement email;

    @AndroidFindBy(xpath = GENDER)
    private MobileElement gender;

    @AndroidFindBy(xpath = NAME)
    private MobileElement name;

    @AndroidFindBy(xpath = LASTNAME)
    private MobileElement lastname;

    @AndroidFindBy(xpath = CI)
    private MobileElement ci;

    @AndroidFindBy(xpath = BIRTHDATE)
    private MobileElement birthdate;

    @AndroidFindBy(xpath = CODEPHONE)
    private MobileElement codephone;

    @AndroidFindBy(xpath = CELLPHONE)
    private MobileElement cellphone;

    @AndroidFindBy(xpath = ADDLISTPAX)
    private MobileElement addlistpax;

    @AndroidFindBy(xpath = BUSSINESNAME)
    private MobileElement bussinesname;

    @AndroidFindBy(xpath = NIT)
    private MobileElement nit;

    @AndroidFindBy(xpath = NEXT)
    private MobileElement next;

    public RegisterPassengerPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public  void selectPaxList(){
        click(listPax.get(0));
    }

    public void enterEmail(String correo){
        dobleClick(email);
        enterText(correo);
    }

    public void clickGender(){
        click(gender);
    }

    public void enterName(String nameuser){
        dobleClick(name);
        enterText(nameuser);
    }

    public void enterLastName(String lastnameuser){
        dobleClick(lastname);
        enterText(lastnameuser);
    }

    public void enterCi(String ciuser){
        dobleClick(ci);
        enterText(ciuser);
    }

    public void enterBithDate(String day,String month,String year){

    }

    public void selectCodePhone(String code){
        dobleClick(codephone);

    }

    public void enterCellPhone(String cell){
        dobleClick(cellphone);
        enterText(cell);
    }

    public void clickAddList(){
        click(addlistpax);
    }

    public void enterBussinesName(String razon){
        dobleClick(bussinesname);
        enterText(razon);
    }

    public void enterNit(String nitP){
        dobleClick(nit);
        enterText(nitP);
    }

    public void clickNext(){
        click(next);
    }
}
