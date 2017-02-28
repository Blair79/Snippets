package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LinearGradient extends JFrame {

	public LinearGradient() {
		GradientPanel gp = new GradientPanel();
		gp.add(new JButton("click"));
		gp.setPreferredSize(new Dimension(200, 200));
		this.add(gp, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setTitle("Frame-Titel");
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new LinearGradient();
	}
}

class GradientPanel extends JPanel {

	public GradientPanel() {
		super();
		setOpaque(true);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		// vertikaler Verlauf von rechts oben nach links unten
		GradientPaint gp = new GradientPaint(getWidth(), 0, Color.BLUE, 0, getHeight(), Color.YELLOW);
		// horizontaler, wiederholter Verlauf
		// GradientPaint gp = new GradientPaint(getWidth()/2, getHeight()/2,
		// Color.BLUE,
		// getWidth(), getHeight()/2, Color.YELLOW, true);
		// diagonaler Verlauf von links oben nach rechts unten
		// GradientPaint gp = new GradientPaint(0, 0, Color.BLUE, getWidth(),
		// getHeight(), Color.YELLOW);
		// vertikaler Verlauf
		// GradientPaint gp = new GradientPaint(getWidth()/2, 0, Color.BLUE,
		// getWidth()/2, getHeight(), Color.YELLOW);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}
}