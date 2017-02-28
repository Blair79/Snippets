package array;

import java.util.Random;

public class Array_mischen {

	private static int[] arrayMix(int[] zahlen) {
		int tmp;
		int rand;
		Random r = new Random();
		for (int i = 0; i < zahlen.length; i++) {
			rand = r.nextInt(zahlen.length);
			tmp = zahlen[i];
			zahlen[i] = zahlen[rand];
			zahlen[rand] = tmp;
		}
		return zahlen;
	}

	public static void main(String[] args) {
		int[] zahlen = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		zahlen = arrayMix(zahlen);
		for (int i : zahlen)
			System.out.println(i);
	}
}