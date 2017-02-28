package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Zeichnet die Silhouette eines Stuhls
 * 
 */
public class FreieFormZeichnen extends JFrame {

	JPanel panel;

	public FreieFormZeichnen() {
		panel = new FreiFormPanel();
		add(panel);

		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FreieFormZeichnen();
	}
}

class FreiFormPanel extends JPanel {
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(Color.BLACK);
		GeneralPath gp = new GeneralPath();

		gp.moveTo(100, 110); // Vorderbein vorne oben
		gp.lineTo(100, 200);
		gp.lineTo(110, 200);
		gp.lineTo(110, 115);
		gp.quadTo(110, 110, 120, 110);
		gp.lineTo(160, 120);
		gp.lineTo(170, 200);
		gp.lineTo(180, 200);
		gp.lineTo(170, 110);
		gp.quadTo(170, 80, 200, 50);
		gp.quadTo(195, 40, 190, 50);
		gp.quadTo(160, 80, 160, 110);
		gp.quadTo(105, 90, 100, 110);

		g2d.draw(gp);
	}
}