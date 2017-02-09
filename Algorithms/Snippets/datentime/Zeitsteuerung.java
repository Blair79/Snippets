package datentime;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Zeitsteuerung extends JFrame {

     private Timer t;
    private JLabel label;

    public Zeitsteuerung() {
        initGUI();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setTitle("Zeitsteuerung");
        this.setVisible(true);
    }

    private void initGUI() {
        label = new JLabel(" ");
        JButton butt1 = new JButton("Start");
        butt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t = new Timer();
                t.schedule(new Task(Zeitsteuerung.this), 0, 1500);
            }
        });
        JButton butt2 = new JButton("Stop");
        butt2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.cancel();
            }
        });
        this.add(label, BorderLayout.NORTH);
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(butt1);
        panel.add(butt2);
        this.add(panel, BorderLayout.SOUTH);
    }
    
    public void setText(String s){
        label.setText(s);
    }
    
    public String getText(){
        return label.getText();
    }

    public static void main(String[] args) {
        new Zeitsteuerung();
    }
}

class Task extends TimerTask {
    Zeitsteuerung z;
    
    public Task(Zeitsteuerung z){
        this.z = z;
    }
    public void run() {
        z.setText(z.getText() + "+");
    }
} 