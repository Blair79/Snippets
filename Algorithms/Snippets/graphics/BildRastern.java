package graphics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BildRastern extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JLabel[] labels;
    private ImageIcon icon;
    private String imgPath = "test.jpg";
    private int anz = 4;
    
    public BildRastern(){
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(anz, anz, 2, 2));
        labels = new JLabel[anz * anz];
        for (int i=0; i<labels.length; i++){
            labels[i] = new JLabel();
            panel.add(labels[i], BorderLayout.CENTER);
        }
        
        this.add(panel, BorderLayout.CENTER);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // Bild erst nach der Definition der Größe importieren
        setImage();
        this.setVisible(true);
    }
    
    private BufferedImage loadImage(){
        File imgFile = new File(imgPath);
        BufferedImage buff = null;
        try {
            buff = ImageIO.read(imgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buff;
    }
    
    private void setImage(){
        BufferedImage bi = loadImage();
        Image newImg;
        int div = (int) Math.sqrt(labels.length);
        for(int i=0; i<div; i++){
            for(int j=0; j<div; j++){
                newImg = bi.getSubimage(j*(this.getWidth()/div), i*(this.getHeight()/div), this.getWidth()/div, this.getHeight()/div);
                icon = new ImageIcon(newImg);
                System.out.println(i*j);
                labels[(i*div+j)].setIcon(icon);
            }
        }
    }

    public static void main(String[] args) {
        new BildRastern();
    }
} 