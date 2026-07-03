package TodoPasaje.Locators;

/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class SearchFlightLocator {
    public static final String FLIGHT_ONEWAY = "Solo ida";
    public static final String FLIGHT_ROUNDTRIP = "Ida y vuelta";
    public static final String LIST_COUNTRY_NAME = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View";
    public static final String FIELD_ORIGIN = "Origen";
    public static final String FIELD_DESTINY = "Destino";
    public static final String TEXT_ROUTE = "android.widget.EditText";
    public static final String LIST_ROUTE = "android.view.View";
    public static final String COUNTRY = "Bolivia";
    public static final String BTN_FLIGHT = "//android.widget.ImageView[@content-desc='vuelos']";
    public static final String TOAST_MESSAGE = "//android.widget.Toast";
    public static final String LIST_ROUTE_CITY = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().descriptionContains(\"%s\").instance(0))"; //"//android.view.View[contains(@content-desc,'%s')]";
    public static final String PICKER_DATE = "Fecha";
    public static final String PICKER_DATES = "Fechas";
    public static final String COUNT_PAXS = "//android.view.View[6]/android.view.View[2]";
    public static final String BTN_SEARCH_FLIGHT = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[8]";
    public static final String VALUE_ORIGIN = "//android.view.View[2]/android.view.View[2]/android.view.View";
    public static final String VALUE_DESTINY = "//android.view.View[4]/android.view.View";
    public static final String VALUE_DATE = "//android.view.View[5]/android.view.View";
    public static final String DAY = "//android.view.View[contains(@content-desc,'%s')]";
    public static final String NEXT_MONTH = "//android.widget.Button[contains(@content-desc,'Next month')]";

}
