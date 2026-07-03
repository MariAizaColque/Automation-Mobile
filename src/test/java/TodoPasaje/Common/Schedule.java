package TodoPasaje.Common;

/**
 * Created by Maribel on 12/14/2020.
 *
 */
public class Schedule {
    public String getMonthENG(String month){
        String monthConvert = month;
        switch (month){
            case "ENERO": monthConvert = "January"; break;
            case "FEBRERO": monthConvert = "February"; break;
            case "MARZO": monthConvert = "March"; break;
            case "ABRIL": monthConvert = "April"; break;
            case "MAYO": monthConvert = "May"; break;
            case "JUNIO": monthConvert = "June"; break;
            case "JULIO": monthConvert = "July"; break;
            case "AGOSTO": monthConvert = "August"; break;
            case "SEPTIEMBRE": monthConvert = "September"; break;
            case "OCTUBRE": monthConvert = "October"; break;
            case "NOVIEMBRE": monthConvert = "November"; break;
            case "DICIEMBRE": monthConvert = "December"; break;
        }
        return monthConvert;
    }

    public String getMonth(int month){
        String monthConvert;
        switch (month){
            case 0: monthConvert = "January"; break;
            case 1: monthConvert = "February"; break;
            case 2: monthConvert = "March"; break;
            case 3: monthConvert = "April"; break;
            case 4: monthConvert = "May"; break;
            case 5: monthConvert = "June"; break;
            case 6: monthConvert = "July"; break;
            case 7: monthConvert = "August"; break;
            case 8: monthConvert = "September"; break;
            case 9: monthConvert = "October"; break;
            case 10: monthConvert = "November"; break;
            case 11: monthConvert = "December"; break;
            default:
                throw new IllegalStateException("Unexpected value: " + month);
        }
        return monthConvert;
    }

}
