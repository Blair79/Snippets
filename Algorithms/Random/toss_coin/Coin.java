package toss_coin;

import java.util.Random;

class Coin {
	public String toss() {
	    Random myRand = new Random();
	    int face = myRand.nextInt(2);
	    if (face == 0) {
	      return "heads";
	    } else {
	      return "tails";
	    }
	  }
}
