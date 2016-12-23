package check_if_a_word_is_a_palindrome;

public class Main {
	public static void main(String[] args) {
	    String n = "level";
	    boolean right = true;
	    int f = n.length() - 1;
	    for (int i = 0; i < n.length(); i++) {
	      if (n.charAt(i) != n.charAt(f - i)) {
	        right = false;
	      }
	    }
	    System.out.println("The word is " + right);
	  }
}
