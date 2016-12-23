package get_random_letters;

import java.util.Random;

public class Main {
	static Random r = new Random();

	  static char pickRandom(char... letters) {
	    return letters[r.nextInt(letters.length)];
	  }

	  public static void main(String args[]) {
	    for (int i = 0; i < 10; i++) {
	      System.out.println("" + pickRandom("ACEGIKMOQSUWY".toCharArray())
	          + pickRandom("BDFHJLNPRVXZ".toCharArray())
	          + pickRandom("ABCDEFGHJKLMOPQRSTVWXYZ".toCharArray()));
	    }
	  }
}
