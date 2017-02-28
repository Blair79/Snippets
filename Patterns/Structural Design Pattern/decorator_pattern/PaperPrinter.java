package decorator_pattern;

class PaperPrinter implements Printer {
	@Override
	public void print() {
		System.out.println("Paper Printer");
	}
}
