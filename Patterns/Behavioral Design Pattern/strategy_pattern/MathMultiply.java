package strategy_pattern;

class MathMultiply implements MathAlgorithm {

	@Override
	public int calculate(int num1, int num2) {
		return num1 * num2;
	}

}
