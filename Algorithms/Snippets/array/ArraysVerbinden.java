package array;

import java.util.Arrays;

public class ArraysVerbinden {

    void create() {
        String[][] arr1 = { new String[] { "00", "01", "02" },
                new String[] { "10", "11", "12" },
                new String[] { "20", "21", "22" } };
        String[][] arr2 = { new String[] { "aa", "ab", "ac" },
                new String[] { "ba", "bb", "bc" },
                new String[] { "ca", "cb", "cc" } };

        int newLength = arr1.length + arr2.length;
        String[][] s = new String[newLength][3];
        s = Arrays.copyOf(arr1, newLength);
        System.arraycopy(arr2, 0, s, arr1.length, arr2.length);

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                System.out.println(s[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        new ArraysVerbinden().create();
    }
} 