package split_a_string_at_every_n_th_character;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		for (String part : getParts("HelloWorldJava", 3)) {
			System.out.println(part);
		}
	}

	private static List<String> getParts(String string, int partitionSize) {
		List<String> parts = new ArrayList<String>();
		int len = string.length();
		for (int i = 0; i < len; i += partitionSize) {
			parts.add(string.substring(i, Math.min(len, i + partitionSize)));
		}
		return parts;
	}
}
