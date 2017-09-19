package builder_pattern;

class WindowBuilder {
	public static MainWindow createWindow() {
		MainWindow window = new MainWindow();
		Menu menu = new Menu();
		ToolBar toolBar = new ToolBar();
		window.setMenu(menu);
		window.setToolBar(toolBar);
		return window;
	}
}
