package datentime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.LocalDate;

public class AktuellesDatumJava8 {

    static void formatDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter df;
        df = DateTimeFormatter.BASIC_ISO_DATE;    // 20160131
        df = DateTimeFormatter.ISO_LOCAL_DATE;    // 2016-18-31
        df = DateTimeFormatter.ISO_DATE_TIME;     // 2016-01-31T20:07:07.095
        System.out.println(now.format(df));       
        df = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");     // 31.01.2016 20:07
        System.out.println(now.format(df));     
    }
    
    static void formatDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter df;
        System.out.println(date);      // 2016-01-31
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);      // Sonntag, 31. Januar 2016
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);      // 31. Januar 2016
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);    // 31.01.2016
        df = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);     // 31.01.16
        System.out.println(date.format(df));
        
    }

    public static void main(String[] args) {
        formatDateTime();
        formatDate();
    }
} 