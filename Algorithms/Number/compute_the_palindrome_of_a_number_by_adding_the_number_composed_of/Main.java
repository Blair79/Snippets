package compute_the_palindrome_of_a_number_by_adding_the_number_composed_of;

import java.math.BigInteger;

/** Compute the Palindrome of a number by adding the number composed of
 * its digits in reverse order, until a Palindrome occurs.
 * e.g., 42->66 (42+24); 1951->5995 (1951+1591=3542; 3542+2453=5995).
 * <P>TODO: Do we need to handle negative numbers?
 * @author Ian Darwin, http://www.darwinsys.com/
 * @version $Id: PalindromeBig.java,v 1.3 2004/02/09 03:33:57 ian Exp $.
 */

public class Main {
	public static boolean verbose = true;

	  public static void main(String[] argv) {
	       BigInteger l = new BigInteger("9999999");
	     System.out.println(findPalindrome(l));
	    
	  }

	  /** find a palindromic number given a starting point, by
	   * calling ourself until we get a number that is palindromic.
	   */
	  public static BigInteger findPalindrome(BigInteger num) {
	    if (num.compareTo(BigInteger.ZERO) < 0)
	      throw new IllegalStateException("negative");
	    if (isPalindrome(num))
	      return num;
	    if (verbose)
	      System.out.println("Trying " + num);
	    return findPalindrome(num.add(reverseNumber(num)));
	  }

	  /** A ridiculously large number  */
	  protected static final int MAX_DIGITS = 255;

	  /** Check if a number is palindromic. */
	  public static boolean isPalindrome(BigInteger num) {
	    String digits = num.toString();
	    int numDigits = digits.length();
	    if (numDigits >= MAX_DIGITS) {
	      throw new IllegalStateException("too big");
	    }
	    // Consider any single digit to be as palindromic as can be
	    if (numDigits == 1)
	      return true;
	    for (int i=0; i<numDigits/2; i++) {
	      // System.out.println(
	      //   digits.charAt(i) + " ? " + digits.charAt(numDigits - i - 1));
	      if (digits.charAt(i) != digits.charAt(numDigits - i - 1))
	        return false;
	    }
	    return true;
	  }

	  static BigInteger reverseNumber(BigInteger num) {
	    String digits = num.toString();
	      int numDigits = digits.length();
	    char[] sb = new char[numDigits];
	    for (int i=0; i<digits.length(); i++) {
	      sb[i] = digits.charAt(numDigits - i - 1);
	    }
	    // Debug.println("rev",
	    //   "reverseNumber(" + digits + ") -> " + "\"" + sb + "\"");
	    return new BigInteger(new String(sb));
	  }
}
