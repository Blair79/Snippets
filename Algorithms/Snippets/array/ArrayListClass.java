package array;

import java.util.ArrayList;

public class ArrayListClass {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		Integer ig = new Integer(17);
		Character ca = new Character('w');
		al.add("Willi");
		al.add(ca);
		al.add(ig);
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}
}