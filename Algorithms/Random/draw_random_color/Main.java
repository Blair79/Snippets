package draw_random_color;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JFrame {
	int grid = 20;
	  int pnlCnt = grid * grid;
	  JFrame frame = new JFrame();
	  JPanel[] panels = new JPanel[pnlCnt];
	  Timer t;

	  public Main() {
	    for (int i = 0; i < panels.length; i++) {
	      final String[] labels = new String[] { "0", "1" };
	      final Random rand = new Random();
	      int index = rand.nextInt(labels.length);
	      String randomTitle = labels[index];
	      final JLabel label = new JLabel(randomTitle, JLabel.CENTER);
	      Timer lblt = new Timer(00, new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent ae) {
	          label.setText(labels[rand.nextInt(labels.length)]);
	        }
	      });
	      lblt.setRepeats(true);
	      lblt.start();
	      label.setForeground(Color.green);
	      label.setVerticalAlignment(JLabel.CENTER);
	      panels[i] = new JPanel();
	      panels[i].setBackground(Color.BLACK);
	      panels[i].add(label);
	      frame.getContentPane().add(panels[i]);
	    }
	    frame.setLayout(new GridLayout(grid, grid));
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	    frame.setUndecorated(true);
	    frame.setVisible(true);

	    ActionListener action = new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        for (int i = 0; i < panels.length; i++) {
	          Color mix = new Color(255, 255, 255);
	          Random random = new Random();
	          int r = random.nextInt(255);
	          int g = random.nextInt(255);
	          int b = random.nextInt(255);

	          if (mix != null) {
	            r = (r + mix.getRed()) / 2;
	            g = (g + mix.getGreen()) / 2;
	            b = (b + mix.getBlue()) / 2;
	          }
	          Color color = new Color(r, g, b);
	          panels[i].setBackground(color);
	        }
	      }
	    };

	    t = new Timer(00, action);
	    t.setRepeats(true);
	    t.start();
	  }

	  public static void main(String args[]) {
	    new Main();
	  }
}
