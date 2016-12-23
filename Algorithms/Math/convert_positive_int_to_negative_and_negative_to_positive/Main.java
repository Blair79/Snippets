package convert_positive_int_to_negative_and_negative_to_positive;

public class Main {
	public static void main(String[] args) throws java.lang.Exception {
		int iPositive = 15;
		int iNegative = (~(iPositive - 1));

		System.out.println(iNegative);

		iPositive = ~(iNegative - 1);
		System.out.println(iPositive);

		iNegative = 0;
		iPositive = ~(iNegative - 1);
		System.out.println(iPositive);
	}
}
