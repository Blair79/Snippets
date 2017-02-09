package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GeradeLinieZiehen extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

    private static final long serialVersionUID = 1L;

    private int startX, startY, tempX, tempY;

    private KeyEvent kEvent = new KeyEvent(this, KeyEvent.KEY_PRESSED, 0, 0, 0, KeyEvent.CHAR_UNDEFINED);

    public GeradeLinieZiehen() {
        this.setFocusable(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaintMode();
        g2.drawLine(startX, startY, tempX, tempY);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new GeradeLinieZiehen());
        frame.setSize(400, 300);
        frame.setTitle("Gerade Linien ziehen");
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
        if (kEvent != null && kEvent.getKeyCode() == KeyEvent.VK_SHIFT) {
            tempX = startX;
        }
        if (kEvent != null && kEvent.getKeyCode() == KeyEvent.VK_CONTROL) {
            tempY = startY;
        }
        this.repaint();
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        kEvent = e;
    }

    public void keyReleased(KeyEvent e) {
        kEvent = null;
    }

    public void keyTyped(KeyEvent e) {
    }
} 