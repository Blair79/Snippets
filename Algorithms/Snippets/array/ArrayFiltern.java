package array;

import java.util.Arrays;
import java.util.Random;

public class ArrayFiltern {

	public static void main(String[] args) {
		Integer[] i = new Integer[100];
		for (int num = 0; num < i.length; num++) {
			i[num] = new Random().nextInt(100);
		}
		Arrays.stream(i).filter(n -> n % 2 == 0).sorted().forEach(k -> System.out.println(k));
	}
}