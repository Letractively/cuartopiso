
package converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FechaConverter{

    public static String convertToString(Date date) {
        DateFormat df;
        String dateString = null;
        df = new SimpleDateFormat("dd/MM/yyyy");
        dateString = df.format(date);
        return dateString;
    }

    public static Date convertToDate(String stringDate) {
        DateFormat df;
        Date date = new Date();
        df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = df.parse(stringDate);
        } catch (ParseException ex) {
            Logger.getLogger(FechaConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
}
