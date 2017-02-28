package generate_random_float_number_within_negative_1_and_1;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 1000000000; i++) {
			float f = random.nextFloat() * 2 - 1;
			if (Float.isNaN(f)) {
				System.out.println("NaN!");
			}
		}
	}
}
