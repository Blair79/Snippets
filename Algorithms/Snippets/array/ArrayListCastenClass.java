package array;

import java.util.ArrayList;

public class ArrayListCastenClass {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Klaus");
		al.add("Willi");
		al.add("Paul");

		String[] s = (String[]) al.toArray(new String[0]);

		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
}