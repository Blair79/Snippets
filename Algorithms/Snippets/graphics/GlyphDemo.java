package graphics;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GlyphDemo extends JFrame {

    private static final long serialVersionUID = 1L;

    JPanel panel;

    JLabel label;

    ImageIcon icon;

    BufferedImage image;

    public GlyphDemo() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        File file = new File("test.jpg");

        try {
            this.image = ImageIO.read(file);
            setSize(image.getWidth(), image.getHeight());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        
        Font f = new Font("Verdana", Font.ITALIC | Font.BOLD, 200);

        GlyphVector gv = f
                .createGlyphVector(g2d.getFontRenderContext(), "Java");

        g2d.fill(new Rectangle2D.Float(0, 0, image.getWidth(), image
                .getHeight()));

        Shape clipping_shape = gv.getOutline();

        g2d.translate(-clipping_shape.getBounds().getX() / 2, -clipping_shape
                .getBounds().getY() + 100);

        g2d.setClip(clipping_shape);

        g2d.setTransform(new AffineTransform());

        g2d.drawImage(image, null, 0, 0);
    }

    public static void main(String args[]) {
        new GlyphDemo();
    }
} 