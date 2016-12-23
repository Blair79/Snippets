package parse_a_mathematical_expression_and_operators_and_solve_it;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {
	public static void main(String[] args) throws Exception {
		String xyz = "3*3+3";
		String kkk = "(100 % 6)* 7";
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine se = manager.getEngineByName("JavaScript");
		Object result1 = se.eval(xyz);
		Object result2 = se.eval(kkk);
		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);
	}
}
