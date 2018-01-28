package graphics;

import java.awt.*;
import javax.swing.JFrame;

public class PaintClass extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaintClass() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void paint(Graphics g) {
		g.drawLine(50, 50, 200, 200);
	}

	public static void main(String[] args) {
		PaintClass pc = new PaintClass();
		pc.setSize(400, 400);
		pc.setVisible(true);
	}

}