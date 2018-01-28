package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AffineTransformation extends JFrame implements ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AffineTransformationPanel panel;

	public AffineTransformation() {
		panel = new AffineTransformationPanel();
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);

		JSlider slider = new JSlider(0, 10, 0);
		slider.addChangeListener(this);
		add(slider, BorderLayout.SOUTH);

		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new AffineTransformation();
	}

	public void stateChanged(ChangeEvent e) {
		panel.setNum((double) ((JSlider) e.getSource()).getValue() / 5);
		panel.repaint();
	}
}

class AffineTransformationPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double num;

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(Color.BLACK);
		int x = 15;
		int y = 10;
		int h = 100;
		int b = 200;
		Rectangle2D.Double rect = new Rectangle2D.Double(x, y, b, h);
		g2d.setColor(Color.RED);
		g2d.draw(rect);

		AffineTransform at = new AffineTransform();
		// (1)Scherung und zusätzliche Translation
		// at.setToShear(num, num/5);
		// at.translate(num*30, num*40);

		// (2)Translation (Verschiebung) und zusätzliche Scherung
		// at.setToTranslation(num*30, num*40);
		// at.shear(num, num/5);

		// (3)Skalierung
		// at.setToScale(num, num);

		// (4)Rotation um den Punkt x/y
		// at.setToRotation(num, x, y);

		// (5)Rotation um den Punkt 0/0
		// at.setToRotation(num);

		Shape s = at.createTransformedShape(rect);
		g2d.setColor(Color.BLACK);
		g2d.draw(s);

		// Verbindung der affinen Transformation mit dem gesamten
		// Grafics-Kontext
		// bewirkt eine Transformation aller nachfolgender Objekte
		g2d.transform(at);
		Line2D.Double line = new Line2D.Double(100, 0, 100, 300);
		g2d.draw(line);
	}

	void setNum(double num) {
		this.num = num;
	}
}