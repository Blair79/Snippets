package array;

public class IndexTausch {

    private static int[] intArr = { 5, 24, 18, 76 };

    public boolean tauschIndex(int l, int r) {

        if (l < 0 || l >= intArr.length) {
            System.err.println("Ausgangsindex zu hoch oder zu niedrig!");
            return false;
        }
        if (r < 0 || r >= intArr.length) {
            System.err.println("Zielindex zu hoch oder zu niedrig!");
            return false;
        }

        int k = intArr[l];
        intArr[l] = intArr[r];
        intArr[r] = k;
        return true;
    }

    public static void main(String[] args) {
        IndexTausch wt = new IndexTausch();
        System.out.println("vorher:");
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
        if (wt.tauschIndex(2, 0)) {
            System.out.println("\nnachher:");
            for (int i = 0; i < intArr.length; i++) {
                System.out.println(intArr[i]);
            }
        }
    }
} 