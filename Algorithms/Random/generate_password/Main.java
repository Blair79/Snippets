package generate_password;

import java.util.Random;

public class Main {
	public static String generatePassword() {
	    Random r[] = new Random[8];
	    r[0] = new Random();
	    r[1] = new Random();
	    r[2] = new Random();
	    r[3] = new Random();
	    r[4] = new Random();
	    r[5] = new Random();
	    r[6] = new Random();
	    r[7] = new Random();
	    Random x = new Random();
	    StringBuilder password = new StringBuilder();
	    int length = 6;
	    password.setLength(length);
	    for (int i = 0; i < length; i++) {
	      x.setSeed(r[i % 8].nextInt(500) * r[4].nextInt(900));
	      password.setCharAt(i, (char) (r[x.nextInt(256) % 8].nextInt(95) + 32));
	    }
	    return password.toString();
	  }
	  public static void main(String[] args) {
	    System.out.println(generatePassword());
	  }
}
