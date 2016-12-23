package template_pattern;

abstract class Software {
	abstract void initialize();
	   abstract void start();
	   abstract void end();
	   public final void play(){
	      //initialize
	      initialize();
	      //start
	      start();
	      //end
	      end();
	   }
}
