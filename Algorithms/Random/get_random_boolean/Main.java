package get_random_boolean;

import java.util.Random;

public class Main {
	public static final void main(String... args) {
	    Random randomGenerator = new Random();
	    for (int idx = 1; idx <= 10; ++idx) {
	      boolean randomBool = randomGenerator.nextBoolean();
	      System.out.println("Generated : " + randomBool);
	    }
	  }
}
