package save_decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
	public static void main(String[] args) {
		double operation = 890.0 / 1440.0;
		BigDecimal big = new BigDecimal(operation);
		big = big.setScale(4, RoundingMode.HALF_UP);
		double d2 = big.doubleValue();
		System.out.println(String.format("operation : %s", operation));
		System.out.println(String.format("scaled : %s", d2));
	}
}
