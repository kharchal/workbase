package ua.com.hav.workbase.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    private static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public static String toString(int date) {
        long value = date;
        value *= 100_000;
        Date d = new Date(value);
        return format.format(d);
    }

    public static int toInt(String date) {
        int val = 0;
        try {
            Date parse = format.parse(date);
            val = (int) (parse.getTime() / 100_000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return val;
    }
}
