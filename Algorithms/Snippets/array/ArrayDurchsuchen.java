package array;

import java.util.Arrays;

public class ArrayDurchsuchen {

    public static void main(String[] args) {
        char[] charArr = { 196, 228, 214, 246, 220, 252, 223 };
        char searched = 246;
        Arrays.sort(charArr);
        // vor Durchsuchung muss Array sortiert sein!
        int i = Arrays.binarySearch(charArr, searched);
        for (int k=0; k<charArr.length; k++)
            System.out.println(k + ".: " + charArr[k]);
        if (i > -1) {
            System.out.println(searched + " an " + i + ". Stelle gefunden.");
        }
    }
} 