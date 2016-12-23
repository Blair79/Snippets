package generate_a_random_negative_1_or_1;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
	    for (int i = 0; i < 100; i++) {
	      System.out.println(randomOneOrMinusOne());
	    }
	  }
	  static int randomOneOrMinusOne() {
	    Random rand = new Random();
	    if (rand.nextBoolean())
	      return 1;
	    else
	      return -1;
	  }
}
