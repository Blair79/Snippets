package search;

import java.util.Arrays;

public class BinarySearch {

    public void searchBinary(int[] intArr, int anfang, int ende, int zahl) {
        
        int grenze = anfang + ((ende - anfang) / 2);
        
        if (intArr.length == 0) {
            System.out.println("Array leer.");
            return;
        }
        
        if (grenze >= intArr.length){
            System.out.println(zahl + " nicht im Array enthalten.");
            return;
        }

        if (zahl > intArr[grenze]) {
            searchBinary(intArr, grenze + 1, ende, zahl);
        } else if (zahl < intArr[grenze] && anfang != grenze) {
            searchBinary(intArr, anfang, grenze - 1, zahl);
        } else if(zahl == intArr[grenze]) {
            System.out.println(zahl + " an Position " + grenze + " enthalten.");
        } else{
            System.out.println(zahl + " nicht im Array enthalten.");
        }
    }

    public static void main(String[] args) {
        int[] testArr = { 5, 3, 5, 228, 14, 69, 18, 27, 109, 85 };
        Arrays.sort(testArr);
        BinarySearch bs = new BinarySearch();
        bs.searchBinary(testArr, 0, testArr.length - 1, 228);
    }
} 