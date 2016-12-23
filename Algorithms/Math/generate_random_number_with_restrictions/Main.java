package generate_random_number_with_restrictions;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random num = new Random();
		int num0, num1, num2, num3, num4, num5, num6, num7;

		num0 = num.nextInt(7) + 1;
		num1 = num.nextInt(8);
		num2 = num.nextInt(8);
		num3 = num.nextInt(643) + 101;
		num4 = num.nextInt(10);
		num5 = num.nextInt(10);
		num6 = num.nextInt(10);
		num7 = num.nextInt(10);

		String randnum = "A random phone number: ";
		System.out.println(randnum + num0 + num1 + num2 + "-" + num3 + "-" + num4 + num5 + num6 + num7);
	}
}
