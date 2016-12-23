package calculate_powers;

public class Main {
	public static void main(String args[]) {
		int num = 2;// from w w w . j av a 2 s . c o m
		int pow = 3;
		System.out.print(power(num, pow));
	}

	public static int power(int a, int b) {
		int power = 1;
		for (int c = 0; c < b; c++)
			power *= a;
		return power;
	}
}