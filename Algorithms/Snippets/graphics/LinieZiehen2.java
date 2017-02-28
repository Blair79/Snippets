package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LinieZiehen2 extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;

	private int startX, startY, tempX, tempY;

	private Image img = null;

	private static final Color BGCOLOR = new Color(170, 100, 100);

	private static final Color FGCOLOR = new Color(10, 200, 10);

	public LinieZiehen2() {
		this.setBackground(BGCOLOR);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaintMode();
		g.drawImage(img, 0, 0, this);
		g2.setColor(FGCOLOR);
		g2.drawLine(startX, startY, tempX, tempY);
	}

	public void zeichne() {
		if (img == null) {
			img = createImage(this.getWidth(), this.getHeight());
		}
		Graphics2D g2d = (Graphics2D) img.getGraphics();
		this.paint(g2d);
		g2d.dispose();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new LinieZiehen2());
		frame.setBackground(BGCOLOR);
		frame.setSize(400, 300);
		frame.setTitle("Eine gerade Linie ziehen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
		zeichne();
	}

	public void mouseDragged(MouseEvent e) {
		tempX = e.getX();
		tempY = e.getY();
		this.repaint();
	}

	public void mouseMoved(MouseEvent e) {
	}
}