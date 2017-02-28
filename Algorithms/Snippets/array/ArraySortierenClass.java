package array;

import java.util.Arrays;

public class ArraySortierenClass {

	public static void main(String[] args) {
		String[] s = new String[7];
		s[0] = "Paul";
		s[1] = "Willi";
		s[2] = "Anton";
		s[3] = "Karl";
		s[4] = "Sepp";
		s[5] = "Petra";
		s[6] = "Peter";

		Arrays.sort(s);
		for (int n = 0; n < s.length; n++) {
			System.out.println(s[n]);
		}
	}
}