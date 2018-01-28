package array;

import java.util.ArrayList;

public class ArrayListZuArrayClass {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		int i = 25;
		while (i < 74) {
			al.add(Integer.valueOf(i));
			i++;
		}
		Integer[] ia = new Integer[al.size()];
		al.toArray(ia);

		int[] inta = new int[al.size()];
		for (int n = 0; n < inta.length; n++) {
			inta[n] = ia[n].intValue();
			System.out.println(inta[n]);
		}
	}
}