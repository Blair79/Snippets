package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class AufBildZeichnenClass extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel panel;

	JLabel label;

	ImageIcon icon;

	BufferedImage image;

	public AufBildZeichnenClass() {

		File file = new File("/pfad/bild.jpg");

		try {
			this.image = ImageIO.read(file);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		int imageBreite = image.getWidth();
		int imageHoehe = image.getHeight();

		Graphics g = image.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 190, 450, 50);
		g.setFont(new Font("Sans", Font.PLAIN, 40));
		g.setColor(Color.WHITE);
		g.drawString("zensiert", 40, 230);

		icon = new ImageIcon(image);
		label = new JLabel(icon);
		label.setBorder(new LineBorder(Color.WHITE));

		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.DARK_GRAY);
		panel.add(label, BorderLayout.CENTER);

		getContentPane().add(panel);
		setSize(imageBreite + 100, imageHoehe + 100);
	}

	public static void main(String args[]) {
		AufBildZeichnenClass cl = new AufBildZeichnenClass();
		cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cl.setVisible(true);
	}
}