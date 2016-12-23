package divide_a_number_into_smaller_random_ints;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Main {
	public static Random r = new Random();

	   public static int[] divide(int number, int number_of_parts) {
	      HashSet<Integer> uniqueInts = new HashSet<Integer>();
	      uniqueInts.add(0);
	      uniqueInts.add(number);
	      int array_size = number_of_parts + 1;
	      while (uniqueInts.size() < array_size) {
	         uniqueInts.add(1 + r.nextInt(number - 1));
	      }
	      Integer[] dividers = uniqueInts.toArray(new Integer[array_size]);
	      Arrays.sort(dividers);
	      int[] results = new int[number_of_parts];
	      for(int i = 1, j = 0; i < dividers.length; ++i, ++j) {
	         results[j] = dividers[i] - dividers[j];
	      }
	      return results;
	   }

	   public static void main(String[] args) {
	      System.out.println(Arrays.toString(divide(12, 5)));
	   }
}
