package array;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CsvToArray {
    private static final String TRENNER = ",";

    public static void main(String[] args) {
        String s = "14,abc,+68,1024,-109,  ,17";
        String[] sa = s.split(TRENNER);
        int[] ia = new int[sa.length];
        for (int i = 0; i < sa.length; i++) {
            sa[i] = sa[i].trim();
            if (sa[i].matches("[-|+]?[0-9]{1,}")) {
                try {
                    ia[i] = new Integer(sa[i]).intValue();
                } catch (NumberFormatException nfe) {
                }
            }
        }
        for(int i : ia) {
            System.out.println(i);
        }
    }
} 