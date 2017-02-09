package array;

import java.util.Arrays;

public class ArrayWandeln2 {
public static void main(String[] args) {
    Object[] oA = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        try {
            Integer[] iA = Arrays.copyOf(oA, oA.length, Integer[].class);
            for (int i : iA) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}