package print_a_table_of_fahrenheit_and_celsius_temperatures_1;

public class Main {
	public static void main(String[] args) {
	    Main t = new Main();
	    t.start();
	    t.data();
	    t.end();
	  }

	  protected void start() {
	  }

	  protected void data() {
	    for (int i=-40; i<=120; i+=10) {
	      float c = (i-32)*(5f/9);
	      print(i, c);
	    }
	  }

	  protected void print(float f, float c) {
	    System.out.println(f + " " + c);
	  }

	  protected void end() {
	  }
}
