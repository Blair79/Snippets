package sort;

public class Oetsort {

    public int[] intArr = { 16, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3, 19 };

    public int[] sort() {
        int k;
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0 + (i % 2); j < intArr.length - 1; j += 2) {
                if (intArr[j] > intArr[j + 1]) {
                    k = intArr[j];
                    intArr[j] = intArr[j + 1];
                    intArr[j + 1] = k;
                }
            }
        }
        return intArr;
    }

    public static void main(String[] args) {
        Oetsort os = new Oetsort();
        int[] arr = os.sort();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + ": " + arr[i]);
        }
    }
} 