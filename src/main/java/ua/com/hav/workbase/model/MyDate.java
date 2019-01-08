package ua.com.hav.workbase.model;

import javax.persistence.Transient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.aspectj.bridge.Version.getTime;

public class MyDate {

    @Transient
    public static final String FORMAT = "dd-MM-yyyy";

    @Transient
    private static final SimpleDateFormat format = new SimpleDateFormat(FORMAT);

    private long value;

    @Transient
    private Date date;

    public MyDate() {
        date = new Date();
        value = date.getTime();
    }

    public MyDate(Date date) {
        this.date = date;
        value = date.getTime();
    }

    public MyDate(long value) {
        setDate(value);
    }

    public MyDate(String date) {
        setDate(date);
    }

    public void setDate(String date) {
        try {
            this.date = format.parse(date);
            value = this.date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setDate(long value) {
        this.value = value;
        date = new Date(value);
    }

    public String getDate() {
        return format.format(date);
    }

    public long getLongValue() {
        return value;
    }

    @Override
    public String toString() {
        return getDate();
    }
}
