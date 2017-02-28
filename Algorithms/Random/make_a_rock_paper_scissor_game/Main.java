package make_a_rock_paper_scissor_game;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		String choice = "S";

		if (choice.equals("S")) {
			generateDraw(Gesture.scissors);
		} else if (choice.equals("R")) {
			generateDraw(Gesture.rock);
		} else if (choice.equals("P")) {
			generateDraw(Gesture.paper);
		}

	}

	public static void generateDraw(Gesture gesture) {
		final Random random = new Random();
		final int computerDraw = random.nextInt(3);
		System.out.println(computerDraw);

		if (computerDraw > gesture.getType()) {
			System.out.println("You lose.");
		} else if (computerDraw < gesture.getType()) {
			System.out.println("You win.");
		} else {
			System.out.println("It is a tie.");

		}
	}
}
