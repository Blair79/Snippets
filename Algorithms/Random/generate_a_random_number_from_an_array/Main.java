package generate_a_random_number_from_an_array;

import java.util.Random;

public class Main {
	public static void main(String... args) {
	    int[] data = new int[] { 1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5, 5, 5 };
	    System.out.print(data[new Random().nextInt(data.length)]);
	  }
}
