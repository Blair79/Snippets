package array;

public class WerteTausch {

    private static int[] intArr = { 5, 24, 18, 76 };

    public boolean tauschValue(int l, int r) {

        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] == l) {
                for (int j = 0; j < intArr.length; j++) {
                    if (intArr[j] == r) {
                        int k = intArr[i];
                        intArr[i] = intArr[j];
                        intArr[j] = k;
                        return true;
                    }
                }
                System.err.println("Zweiter Wert nicht im Array vorhanden!");
                return false;
            }
        }
        System.err.println("Erster Wert nicht im Array vorhanden!");
        return false;
    }

    public static void main(String[] args) {
        WerteTausch wt = new WerteTausch();
        System.out.println("vorher:");
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
        if (wt.tauschValue(5, 76)) {
            System.out.println("\nnachher:");
            for (int i = 0; i < intArr.length; i++) {
                System.out.println(intArr[i]);
            }
        }
    }
} 