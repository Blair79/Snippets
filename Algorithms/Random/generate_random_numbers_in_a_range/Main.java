package generate_random_numbers_in_a_range;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int randomNumberBetween1To100 = getRandom(0, 100);
		System.out.println("Random number between 1 to 100 is: " + randomNumberBetween1To100);
	}

	public static int getRandom(int minNumber, int maxNumber) {
		Random rand = new Random();
		int randomNum = rand.nextInt(maxNumber - minNumber);
		return randomNum;
	}
}
