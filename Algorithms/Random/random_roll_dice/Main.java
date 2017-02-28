package random_roll_dice;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		System.out.println("Total is: " + Dice.rollDice(3, 6));
	}
}

class Dice {
	public static int rollDice(int number, int nSides) {
		int num = 0;
		int roll = 0;
		Random r = new Random();
		if (nSides >= 3) {
			for (int i = 0; i < number; i++) {
				roll = r.nextInt(nSides) + 1;
				System.out.println("Roll is:  " + roll);
				num = num + roll;
			}
		} else {
			System.out.println("Error num needs to be from 3");
		}
		return num;
	}
}
