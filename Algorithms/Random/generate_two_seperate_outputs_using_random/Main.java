package generate_two_seperate_outputs_using_random;

import java.util.Random;

public class Main {
	private static final Random rand = new Random();

	public static void main(String[] args) {
		int i = 1;
		while (i <= 100) {
			System.out.printf("%-5d", rand.nextInt(4) + 4);
			if (i % 10 == 0) {
				System.out.println();
			}
			i++;
		}
		System.out.println();
		i = 1;// modified here
		while (i <= 100) {
			System.out.printf("%-5d", rand.nextInt(10 * (80) + 10));
			if (i % 10 == 0) {
				System.out.println();
			}
			i++;
		}
	}
}
