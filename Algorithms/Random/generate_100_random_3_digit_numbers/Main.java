package generate_100_random_3_digit_numbers;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random rand = new Random();
		for (int i = 1; i <= 100; i++) {
			int randomNum = rand.nextInt((999 - 100) + 1) + 100;
			System.out.println(randomNum);
		}
	}
}
