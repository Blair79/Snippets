package convert_mathematical_string_to_int;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {
	public static void main(String[] args) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		engine.put("a", 1);
		engine.put("b", 2);
		try {
			String expression = "(a + b) > 2";
			Object result = engine.eval(expression);
			System.out.println(expression + " ? " + result);
		} catch (ScriptException se) {
			se.printStackTrace();
		}
	}
}
