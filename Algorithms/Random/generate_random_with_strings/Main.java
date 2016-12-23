package generate_random_with_strings;

import java.util.Random;

public class Main {
	public static void main(String[] args) {

	    String[] arr = { "A", "B", "C", "D" };
	    Random random = new Random();

	    int select = random.nextInt(arr.length);

	    System.out.println("Random String selected: " + arr[select]);
	  }
}
