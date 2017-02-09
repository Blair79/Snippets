package inout;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BrowserOeffnen extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    JButton localButt;
    JButton iNetButt;

    public BrowserOeffnen() {
        localButt = new JButton("local");
        localButt.addActionListener(this);
        iNetButt = new JButton("Inet");
        iNetButt.addActionListener(this);
        this.setLayout(new FlowLayout());
        this.add(localButt);
        this.add(iNetButt);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void ladeINet(String seite) {
        try {
            Desktop.getDesktop().browse(new URI(seite));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void ladeLocal(String seite) {
        File tmpIndexFile = null;
        StringBuffer sb = new StringBuffer();
        PrintWriter pWriter = null;
        InputStream is = null;
        try {
            is = this.getClass().getClassLoader()
                    .getResourceAsStream(seite);
            if (is != null) {
                int b = 0;
                while ((b = is.read()) != -1) {
                    sb.append((char) b);
                }

                tmpIndexFile = File.createTempFile("javabeginners", ".htm");
                tmpIndexFile.deleteOnExit();
                if (tmpIndexFile.canWrite()) {
                    pWriter = new PrintWriter(tmpIndexFile);
                    pWriter.write(sb.toString());
                } else {
                    System.out.println("Tmp-File nicht beschreibbar");
                    return;
                }
                Desktop.getDesktop().browse(tmpIndexFile.toURI());

            } else {
                System.out.println("Laden nicht erfolgreich...");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
                if (pWriter != null) pWriter.close();
            } catch (IOException ioe) {}
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == localButt)
            ladeLocal("test.htm");
        if (e.getSource() == iNetButt)
            ladeINet("http://www.javabeginners.de");
    }

    public static void main(String[] args) {
        new BrowserOeffnen();
    }
} 