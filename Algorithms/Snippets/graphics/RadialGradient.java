package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RadialGradient extends JFrame {

	public RadialGradient() {
		RoundGradientPanel gp = new RoundGradientPanel();
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
		new RadialGradient();
	}
}

class RoundGradientPanel extends JPanel {

	public RoundGradientPanel() {
		super();
		setOpaque(true);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		int w = getWidth(), h = getHeight();
		Point2D center = new Point2D.Float(w / 2, h / 2);
		float radius = w / 4;
		float[] dist = { 0.0f, 0.5f, 1.0f };
		Point2D focus = new Point2D.Float(w / 2, h / 2);
		Color[] colors = { Color.BLUE, Color.GREEN, Color.YELLOW };
		RadialGradientPaint rgp = new RadialGradientPaint(center, radius, focus, dist, colors, CycleMethod.NO_CYCLE);
		g2d.setPaint(rgp);
		g2d.fillRect(0, 0, w, h);
	}
}