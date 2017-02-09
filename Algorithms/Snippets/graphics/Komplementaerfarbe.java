package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Komplementaerfarbe extends JFrame {

    JLabel topLabel, bottomLabel;

    public Komplementaerfarbe() {
        initGUI();
    }

    private void initGUI() {
        Font f = new Font("Helvetica", Font.PLAIN, 20);
        topLabel = new JLabel();
        topLabel.setFont(f);
        topLabel.setOpaque(true);
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bottomLabel = new JLabel();
        bottomLabel.setFont(f);
        bottomLabel.setOpaque(true);
        bottomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        paintLabels();
        JPanel labelPanel = new JPanel(new GridLayout(2, 1));
        labelPanel.add(topLabel);
        labelPanel.add(bottomLabel);
        this.add(labelPanel, BorderLayout.CENTER);
        JButton changeButton = new JButton("Farbe wechseln");
        changeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paintLabels();
            }
        });
        this.add(changeButton, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Komplement\u00E4rfarbe");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private Color createKompCol(Color c) {
        int r = 255 - c.getRed();
        int g = 255 - c.getGreen();
        int b = 255 - c.getBlue();
        return new Color(r, g, b);
    }

    private void paintLabels() {
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        Color c = new Color(r, g, b);
        topLabel.setBackground(c);
        topLabel.setText("Rot: " + c.getRed() + ", Gr\u00FCn: " + c.getGreen()
                + ", Blau: " + c.getBlue());
        Color kc = createKompCol(c);
        bottomLabel.setBackground(kc);
        bottomLabel.setText("Rot: " + kc.getRed() + ", Gr\u00FCn: "
                + kc.getGreen() + ", Blau: " + kc.getBlue());
    }

    public static void main(String[] args) {
        new Komplementaerfarbe();
    }
} 