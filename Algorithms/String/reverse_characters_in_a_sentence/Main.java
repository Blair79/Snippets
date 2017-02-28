package reverse_characters_in_a_sentence;

import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		String input = "This is a sentence";
		char[] charinput = input.toCharArray();
		Stack<String> stack = new Stack<String>();
		for (int i = input.length() - 1; i >= 0; i--) {
			stack.push(String.valueOf(charinput[i]));
		}
		StringBuilder StackPush = new StringBuilder();
		for (int i = 0; i < stack.size(); i++) {
			StackPush.append(stack.get(i));
		}
		System.out.println(StackPush.toString());
	}
}
