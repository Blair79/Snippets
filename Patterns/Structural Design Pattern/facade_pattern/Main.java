package facade_pattern;

public class Main {
	public static void main(String[] args) {
		ShapeFacade shapeFacade = new ShapeFacade();
		shapeFacade.drawCircle();
		shapeFacade.drawRectangle();
		shapeFacade.drawSquare();
	}
}
