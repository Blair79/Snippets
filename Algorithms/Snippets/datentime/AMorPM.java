package datentime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AMorPM {

    public static void main(String[] args) {
        amOrPm();
        amOrPmJava8();
    }

    private static void amOrPm() {
        GregorianCalendar cal = (GregorianCalendar) GregorianCalendar
                .getInstance();
        Date time = new Date();
        cal.setTime(time);
        int h = cal.get(Calendar.HOUR);
        int m = cal.get(Calendar.MINUTE);
        if (cal.get(Calendar.AM_PM) == Calendar.AM)
            System.out.println(h + ":" + m + "AM");
        else
            System.out.println(h + ":" + m + "PM");
    }

    private static void amOrPmJava8() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("K:ma");
        System.out.println(time.format(df));
    }
} 