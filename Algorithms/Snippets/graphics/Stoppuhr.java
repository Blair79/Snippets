package graphics;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Stoppuhr extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton startButt, stopButt, resetButt;
	private UhrPanel panel;

	public Stoppuhr() {
		panel = new UhrPanel();
		panel.setRunning(false);
		this.add(panel, BorderLayout.CENTER);

		startButt = new JButton("start");
		startButt.addActionListener(this);
		stopButt = new JButton("stop");
		stopButt.addActionListener(this);
		resetButt = new JButton("reset");
		resetButt.addActionListener(this);
		JPanel buttPanel = new JPanel(new FlowLayout());
		buttPanel.add(startButt);
		buttPanel.add(stopButt);
		buttPanel.add(resetButt);
		this.add(buttPanel, BorderLayout.SOUTH);

		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Stoppuhr();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButt) {
			panel.setRunning(true);
		}
		if (e.getSource() == stopButt) {
			panel.setRunning(false);
		}
		if (e.getSource() == resetButt) {
			panel.setIndex(0);
			panel.setRunning(false);
			panel.repaint();
		}
	}
}

class UhrPanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UhrPanel() {
		start();
	}

	double winkel = Math.PI / -30;
	int index = 0;
	boolean running;
	private Thread thread;

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

		AffineTransform at = new AffineTransform();
		at.setToScale(1, -1);
		AffineTransform aff = new AffineTransform();
		aff.setToTranslation(this.getWidth() / 2, this.getHeight() / 2);
		at.preConcatenate(aff);
		g2d.transform(at);

		// Zifferzeichen
		g2d.setColor(Color.RED);
		Line2D.Double ziffer = new Line2D.Double(0, 60, 0, 70);
		Shape zShape;
		for (int i = 0; i < 61; i += 5) {
			at.setToRotation(winkel * i);
			zShape = at.createTransformedShape(ziffer);
			g2d.draw(zShape);
		}

		// Zifferzeichen an den Positionen 12/3/6/9
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(3));
		Line2D.Double viertel = new Line2D.Double(0, 60, 0, 70);
		Shape qShape;
		for (int i = 0; i < 61; i += 15) {
			at.setToRotation(winkel * i);
			qShape = at.createTransformedShape(viertel);
			g2d.draw(qShape);
		}

		// Zeiger
		g2d.setColor(Color.BLACK);
		Line2D.Double line = new Line2D.Double(0, 0, 0, 50);
		at.setToRotation(winkel * index, 0, 0);
		Shape s = at.createTransformedShape(line);
		g2d.draw(s);

	}

	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void setIndex(int i) {
		this.index = i;
	}

	public void run() {
		while (true) {
			if (running) {
				index++;
				index = index > 60 ? 1 : index;
				repaint();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}