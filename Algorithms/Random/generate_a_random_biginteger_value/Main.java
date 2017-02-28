package generate_a_random_biginteger_value;

import java.math.BigInteger;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		BigInteger bigInteger = new BigInteger("2000000000000");// uper limit
		BigInteger min = new BigInteger("1000000000");// lower limit
		BigInteger bigInteger1 = bigInteger.subtract(min);
		Random rnd = new Random();
		int maxNumBitLength = bigInteger.bitLength();

		BigInteger aRandomBigInt;

		aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
		if (aRandomBigInt.compareTo(min) < 0)
			aRandomBigInt = aRandomBigInt.add(min);
		if (aRandomBigInt.compareTo(bigInteger) >= 0)
			aRandomBigInt = aRandomBigInt.mod(bigInteger1).add(min);

		System.out.println(aRandomBigInt);
	}
}
