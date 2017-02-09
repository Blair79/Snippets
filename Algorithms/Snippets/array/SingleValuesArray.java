package array;

import java.util.Arrays;
import java.util.Random;

public class SingleValuesArray {

    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(Arrays.toString(initialize(arr)));
    }

    private static int[] initialize(int[] arr) {
        int num, i = 0;
        boolean exists;
        while (i < arr.length) {
            num = new Random().nextInt(10);
            exists = false;
            for (int j = 0; j < i; j++) {
                if (num == arr[j]) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                arr[i] = num;
                ++i;
            }
        }
        return arr;
    }
} 