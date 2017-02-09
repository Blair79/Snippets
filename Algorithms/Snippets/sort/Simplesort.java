package sort;

public class Simplesort {

    public int[] intArr = { 16, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3, 19 };

    public int[] sort() {
        int k;
        for (int i = intArr.length-1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (intArr[j] >= intArr[i]) {
                    k = intArr[i];
                    intArr[i] = intArr[j];
                    intArr[j] = k;
                }
            }
        }
        return intArr;
    }

    public static void main(String[] args) {
        Simplesort ss = new Simplesort();
        int[] arr = ss.sort();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + ": " + arr[i]);
        }
    }
} 