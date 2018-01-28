package array;

import java.io.Serializable;
import java.util.ArrayList;

public class ArrayListClass {
	public static void main(String[] args) {
		ArrayList<Serializable> al = new ArrayList<Serializable>();
		Integer ig = Integer.valueOf(17);
		Character ca = Character.valueOf('w');
		al.add("Willi");
		al.add(ca);
		al.add(ig);
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}
}