package snippets;

import javax.swing.JFrame;

public class ShutdownBsp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShutdownBsp() {
		Runtime.getRuntime().addShutdownHook(new ShutdownThread());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Shutdown Hook");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ShutdownBsp();
	}
}

class ShutdownThread extends Thread {
	public void run() {
		System.out.println("Programm wird geschlossen.");
	}
}