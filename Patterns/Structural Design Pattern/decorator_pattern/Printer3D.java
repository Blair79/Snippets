package decorator_pattern;

class Printer3D extends PrinterDecorator {
	public Printer3D(Printer decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void print() {
		System.out.println("3D.");
		decoratedPrinter.print();
	}
}
