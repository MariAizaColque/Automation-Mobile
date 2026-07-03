package TodoPasaje.PageObject;

import TodoPasaje.Common.EventListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static TodoPasaje.Locators.PaxAndFaresLocator.*;

/**
 * Created by Maribel on 1/6/2021.
 *
 */
public class TypePaxFarePage extends EventListener{
    private AppiumDriver<MobileElement> driver;

    @AndroidFindBy(xpath = ECONOMIC)
    private MobileElement economic;

    @AndroidFindBy(xpath = EXECUTIVE)
    private MobileElement executive;

    @AndroidFindBy(xpath = FIRST)
    private MobileElement first;

    @AndroidFindBy(xpath = ADULT)
    private MobileElement adult;

    @AndroidFindBy(xpath = CHILD)
    private MobileElement child;

    @AndroidFindBy(xpath = INFANT)
    private MobileElement infant;

    @AndroidFindBy(xpath = CONTINUE)
    private MobileElement continuar;

    public TypePaxFarePage(AppiumDriver<MobileElement> driver ) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectEconomic(int adults, int children, int infants){
        click(economic);
        for(int i=0;i<adults;i++){
            click(adult);
        }
        if(children>0){
            for(int i=0;i<children;i++){
                click(child);
            }
        }
        if(infants>0){
            for(int i=0;i<infants;i++){
                click(infant);
            }
        }
        click(continuar);
    }
}
