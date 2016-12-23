package evaluate_math_expressions_in_string;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Main {
	public static void main(String[] args) throws Exception {
		// create a script engine manager
		ScriptEngineManager factory = new ScriptEngineManager();
		// create a JavaScript engine
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		// evaluate JavaScript code from String
		Object obj = engine.eval("1+2");
		System.out.println(obj);
	}
}
