package graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BogenZeichnen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;

	public BogenZeichnen() {

		panel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());

				g.setColor(Color.RED);
				g.drawLine(100, 10, 100, 100);
				g.setColor(Color.GREEN);
				g.drawArc(100, 75, 50, 50, 180, 90);
				g.setColor(Color.BLUE);
				g.drawArc(100, 125, 50, 50, 90, -180);
				g.setColor(Color.BLACK);
				g.drawArc(115, 175, 20, 20, 90, 180);
				g.drawArc(120, 195, 10, 10, 90, -180);

			}
		};
		add(panel);

		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BogenZeichnen();
	}
}