package array;

import java.util.Arrays;

public class ArrayWandeln {
	public static void main(String[] args) {
		Object[] oA = { "Ene", "mene", "Maus", "und", "Du", "bist", "raus" };
		@SuppressWarnings("unused")
		String[] sA = Arrays.copyOf(oA, oA.length, String[].class);
	}
}