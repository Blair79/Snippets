package generate_random_values_that_not_repeat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
	    Random random = new Random();
	    Set<Integer> set = new HashSet<Integer>();
	    while (set.size() < 5) {
	      set.add(random.nextInt());
	    }
	    List<Integer> result = new ArrayList<Integer>(set);
	    System.out.println(result);
	  }
}
