package get_the_prime_numbers;

import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
		int i = 0;
		while (true) {
			if (i > 1000000) {
				break;
			}
			if (i > 1) {
				if (new BigInteger(i + "").isProbablePrime(i / 2)) {
					System.out.println(i);
				}
			}
			i++;
		}
	}
}
