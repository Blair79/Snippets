package search;

import java.util.Arrays;

public class InterpolationSearch {

    public void search(int[] intArr, int anfang, int ende, int zahl) {

        int bereich = intArr[ende] - intArr[anfang];
        int grenze = anfang
                + (int) (((double) ende - anfang) * (zahl - intArr[anfang]) / bereich);

        if (intArr.length == 0) {
            System.out.println("Array leer.");
            return;
        }

        if (grenze >= intArr.length) {
            System.out.println(zahl + " nicht im Array enthalten.");
            return;
        }
        System.out.println("Anfang: " + anfang + ", Ende: " + ende
                + ", Grenze: " + grenze);
        if (zahl > intArr[grenze]) {
            search(intArr, grenze + 1, ende, zahl);
        } else if (zahl < intArr[grenze] && anfang != grenze) {
            search(intArr, anfang, grenze - 1, zahl);
        } else if (zahl == intArr[grenze]) {
            System.out.println(zahl + " an Position " + grenze
                    + " des Arrays enthalten.");
        } else {
            System.out.println(zahl + " nicht im Array enthalten.");
        }
    }

    public static void main(String[] args) {
        int[] testArr = { 5, 3, 5, 228, 14, 69, 18, 27, 109, 85 };
        Arrays.sort(testArr);
        InterpolationSearch is = new InterpolationSearch();
        is.search(testArr, 6, testArr.length - 1, 14);
    }
} 