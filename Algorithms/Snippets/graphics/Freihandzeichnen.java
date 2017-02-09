package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Freihandzeichnen extends JPanel implements MouseListener, MouseMotionListener {

    private int startX, startY, tempX, tempY;
    
    private Graphics2D g2;

    public Freihandzeichnen() {
        System.out.println("Freihandzeichnen aufgerufen...");
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    protected void paintComponent(Graphics g) {
        // hier darf kein super.paintComponent() aufgerufen werden!
        g2 = (Graphics2D) g;
        g2.setPaintMode();
        g2.drawLine(startX, startY, tempX, tempY);
        startX = tempX;
        startY = tempY;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Freihandzeichnen());
        frame.setSize(400, 300);
        frame.setTitle("Freihandzeichnen");
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
    }

    public void mouseDragged(MouseEvent e) {
        tempX = e.getX();
        tempY = e.getY();
        repaint();
    }

    public void mouseMoved(MouseEvent e) {
    }
}  