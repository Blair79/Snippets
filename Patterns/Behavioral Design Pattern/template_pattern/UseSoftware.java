package template_pattern;

abstract class UseSoftware {
	abstract void download();

	abstract void install();

	abstract void configuration();

	abstract void run();

	public void useNewSoftware() {
		download();
		install();
		configuration();
		run();
	}
}
