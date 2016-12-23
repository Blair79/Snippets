package generate_random_number_between_two_given_values;

public class Main {
	public static void main(String[] args) {
	    int n1 = 1;//from  w  w  w . j  av a 2 s .c  o  m
	    int n2 = 100;
	    double Random;

	    Random = n2 + (Math.random() * (n1 - n2));
	    System.out.println("Your random number is: " + Random);
	  }
}
