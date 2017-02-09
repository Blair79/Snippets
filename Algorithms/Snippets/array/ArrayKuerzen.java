package array;

public class ArrayKuerzen {

    public static void main(String[] args) {
        int[] longArr = {5, 17, 23, 8, 18, 36, 56, 9, 10, 12};
        int count = 0;
        for(int i : longArr) {
            if(i%2==0)
                count++;
        }
        int[] shortArr = new int[count];
        int k=0;
        for(int i : longArr) {
            if(i%2==0) {
                shortArr[k] = i;
                k++;
            }
        }
        for(int i : shortArr)
            System.out.println(i); 
    }
} 