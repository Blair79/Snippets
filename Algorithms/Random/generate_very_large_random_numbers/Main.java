package generate_very_large_random_numbers;

import java.math.BigInteger;
import java.util.Random;

public class Main {
	public static void main(String... a) {
	    int n = 16;

	    Random r = new Random();
	    byte[] b = new byte[n];
	    r.nextBytes(b);
	    BigInteger i = new BigInteger(b);

	    System.out.println(i);
	  }
}
