package toss_coin;

public class Main {
	public static void main(String[] args) {
	    Coin coin = new Coin();
	    int headsCount = 0;
	    int tailsCount = 0;
	    for (int i = 1; i <= 40; i++) {
	      if (coin.toss().equals("heads")) {
	        headsCount++;
	      } else {
	        tailsCount++;
	      }
	    }
	    System.out.println("Total number of heads: " + headsCount
	        + "\nTotal number of tails: " + tailsCount);
	  }
}
