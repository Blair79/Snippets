package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ManipulateImage extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel panel;

	JLabel label;

	ImageIcon icon;

	BufferedImage image;

	public ManipulateImage() {

		// processImage();
		makeImage();

		icon = new ImageIcon(image);
		label = new JLabel(icon);
		label.setBorder(new LineBorder(Color.WHITE));

		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.DARK_GRAY);
		panel.add(label, BorderLayout.CENTER);

		getContentPane().add(panel);
		setSize(image.getWidth() + 100, image.getHeight() + 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void makeImage() {
		int width = 200, height = 200;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		WritableRaster raster = image.getRaster();
		ColorModel model = image.getColorModel();

		Color c1 = Color.RED;
		int argb1 = c1.getRGB();
		Object data1 = model.getDataElements(argb1, null);

		Color c2 = Color.GRAY;
		int argb2 = c2.getRGB();
		Object data2 = model.getDataElements(argb2, null);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				raster.setDataElements(i, j, data1);
				if (i > 50 && i < 150 && j > 50 && j < 150) {
					raster.setDataElements(i, j, data2);
				}
			}
		}
	}

	public static void main(String args[]) {
		new ManipulateImage();
	}
}