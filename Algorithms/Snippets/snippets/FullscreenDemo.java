package snippets;

/*
 * Das Snippet demonstriert die Anwendung einer Fullscreen-Ansicht in Verbindung mit nicht modalen Dialogen,
 * die jederzeit &uuml;ber dem Hauptfenster sichtbar sein m&uuml;ssen.
 *
 */
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/*
 * @FullscreenDemo.java     12.02.2010
 * build: 12.02.2010
 * Copyright 2010 javabeginners.de. All rights reserved
 * @author Joerg Czeschla
 * 
 * This file is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.

 * This file is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License along with this file;
 * if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */

public class FullscreenDemo {

	public static void main(String[] args) {
		if (System.getProperty("os.name").equals("Mac OS X")) {
			// in multi-screen-Umgebungen: nur ein screen ist fullscreen
			// der zweite wird nicht schwarz
			System.setProperty("apple.awt.fullscreencapturealldisplays", "false");
			// fullscreen in einem Window; erm&oumlglicht die Darstellung des
			// Kontextmenus
			System.setProperty("apple.awt.fakefullscreen", "true");
		}
		new MainFrame();
	}
} // Ende class FullscreenDemo

/*
 * Stellt das GUI des Hauptfensters bereit
 */
@SuppressWarnings("serial")
class MainFrame extends JFrame implements ActionListener {

	private GraphicsDevice myDevice;
	private JButton showButt, exitButt, fullscreenButt;
	private boolean isFullscreen;

	public MainFrame() {
		fullscreenButt = new JButton("Fullscreen ein");
		fullscreenButt.addActionListener(this);
		showButt = new JButton("MenuDialog zeigen");
		showButt.addActionListener(this);
		this.add(showButt);
		exitButt = new JButton("Exit");
		exitButt.addActionListener(this);
		this.add(exitButt);
		JPanel topPanel = new JPanel(new FlowLayout());
		topPanel.add(showButt);
		topPanel.add(exitButt);
		topPanel.add(fullscreenButt);

		this.setLayout(new BorderLayout());
		this.add(new MainPanel(), BorderLayout.CENTER);
		this.add(topPanel, BorderLayout.NORTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(false);
		this.setSize(this.getToolkit().getScreenSize());

		if (isFullscreen)
			initDisplayMode();
		else
			this.setVisible(true);

	} // Konstruktor

	private void initDisplayMode() {
		if (checkFullscreen() && !this.isFullscreen) {
			// Kommentar entfernen, um zu einer statischen Aufloesung von 1024 x
			// 768 Pixeln zu wechseln
			// DisplayMode oldDisplayMode = myDevice.getDisplayMode();
			// DisplayMode prefDisplayMode = new DisplayMode(1024,
			// 768,32,DisplayMode.REFRESH_RATE_UNKNOWN);
			// if(myDevice.isDisplayChangeSupported()) {
			// myDevice.setDisplayMode(prefDisplayMode);
			// }

			this.removeNotify();
			this.setVisible(false);
			this.setUndecorated(!this.isUndecorated());
			if (this.isUndecorated()) {
				// unter Win try-catch-block verwenden um eine stabile
				// fullscreen-Darstellung zu erzeugen
				// unter Unix(en) diese vermeiden sonst sind
				// unter Mac OS X Leiste und Dock nicht verborgen
				if (System.getProperty("os.name").indexOf("Windows") != -1) {
					try {
						myDevice.setFullScreenWindow(this);
						this.setSize(getToolkit().getScreenSize());
					} catch (Exception e) {
					} finally {
						myDevice.setFullScreenWindow(null);
					}
				} else {
					// Fullscreen-Modus aktivieren
					myDevice.setFullScreenWindow(this);
					this.setSize(getToolkit().getScreenSize());
				}
				isFullscreen = true;
			} else {
				this.setUndecorated(false);
				isFullscreen = false;
			}
			this.addNotify();
		} else {
			// konventionelles 'undecorated window' zeigen falls graphic device
			// kein 'fullscreen' unterstuetzt
			this.dispose();
			if (!this.isUndecorated()) {
				this.setUndecorated(true);
				isFullscreen = true;
			} else {
				this.setUndecorated(false);
				isFullscreen = false;
			}
			this.requestFocus();
			this.setLocation(0, 0);
		}
		this.repaint();
		this.setVisible(true);
	}

	// wird 'fullscreen' unterstuetzt?
	public boolean checkFullscreen() {
		myDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		return myDevice.isFullScreenSupported();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButt) {
			System.exit(0);
		}
		if (e.getSource() == showButt) {
			MenuDialog md = MenuDialog.getMenuDialog();
			md.setVisible(true);
			md.setFocusable(true);
			md.requestFocus();
		}
		if (e.getSource() == fullscreenButt) {
			initDisplayMode();
			fullscreenButt.setText("Fullscreen ein");
			if (isFullscreen)
				fullscreenButt.setText("Fullscreen aus");
		}
	}
}

/*
 * Nicht modale Elternklasse aller Dialoge, die sich bei Sichtbatrkeit immer
 * ueber dem Hauptfenster befinden.
 */
@SuppressWarnings("serial")
class DialogTemplate extends JDialog implements ActionListener {
	public DialogTemplate() {
		super();
		this.setLayout(new BorderLayout(5, 5));
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setUndecorated(false);
		this.setFocusable(true);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}

/*
 * Stellt einen nicht-modalen Datei-Auswahl-Dialog bereit
 */
@SuppressWarnings("serial")
class FileSelector extends DialogTemplate {
	private JFileChooser chooser;
	OKDialog okDialog;
	JLabel pfadLabel;

	public FileSelector() {
		super();
		okDialog = new OKDialog(this);
		pfadLabel = new JLabel("Abbruch?");
		okDialog.add(pfadLabel, BorderLayout.CENTER);
		chooser = new JFileChooser();
		chooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = chooser.getSelectedFile();
				if (file != null && e.getActionCommand().equals(JFileChooser.APPROVE_SELECTION)) {
					pfadLabel.setText(chooser.getSelectedFile().getAbsolutePath());
				}
				if (okDialog != null) {
					okDialog.setBounds(400, 400, 200, 150);
					okDialog.pack();
					okDialog.setVisible(true);
				}
			}
		});
		this.setBounds(100, 100, 400, 300);
		this.add(chooser, BorderLayout.CENTER);
		this.setVisible(false);
	}
}

/*
 * Stellt ein Panel bereit, das im Hauptfenster geladen ist und die
 * Rechtsklick-Funktionalitaet liefert
 */
@SuppressWarnings("serial")
class MainPanel extends JPanel {

	public MainPanel() {
		this.enableEvents(AWTEvent.MOUSE_EVENT_MASK);
		this.add(new JLabel("hier rechts klicken!"));
		this.setOpaque(true);
		this.validate();
	} // Ende Konstruktor

	/*
	 * Zeigt einen einfachen Dialog durch Rechtsklick als Kontextmenu an.
	 */
	@Override
	public void processMouseEvent(MouseEvent event) {

		if (event.isPopupTrigger()) {
			MenuDialog menuDialog = MenuDialog.getMenuDialog();
			final int x = ((JPanel) event.getSource()).getX() + event.getX();
			final int y = ((JPanel) event.getSource()).getY() + event.getY();
			menuDialog.setLocation(x, y);
			if (!menuDialog.isVisible() || !menuDialog.hasFocus()) {
				menuDialog.setFocusable(true);
				menuDialog.requestFocus();
				menuDialog.setVisible(true);
			} else {
				this.requestFocus();
			}
		}
		super.processMouseEvent(event);
	}
}

/*
 * Stellt ein einfachen, nicht modalen Menu-Dialog als Singleton bereit
 */
@SuppressWarnings("serial")
class MenuDialog extends DialogTemplate {
	JButton showButt, exitButt;
	FileSelector fileSelector = null;
	private static MenuDialog menuDialog = new MenuDialog();

	public MenuDialog() {
		super();
		showButt = new JButton("Datei-Auswahl-Dialog zeigen");
		showButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fileSelector == null)
					fileSelector = new FileSelector();
				fileSelector.setVisible(true);
			}
		});
		exitButt = new JButton("Abbruch");
		exitButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDialog.this.setVisible(false);
			}
		});
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(showButt);
		panel.add(exitButt);
		this.add(panel, BorderLayout.SOUTH);
		this.setBounds(300, 300, 300, 300);
		this.pack();
	}

	public static MenuDialog getMenuDialog() {
		if (menuDialog == null)
			menuDialog = new MenuDialog();
		return menuDialog;
	}
}

/*
 * Stellt einen einfachen, nicht modalen Bestaetigungsdialog bereit
 */
@SuppressWarnings("serial")
class OKDialog extends DialogTemplate {
	private JButton okButt;
	Component parent;

	public OKDialog(Component parent) {
		super();
		this.parent = parent;
		okButt = new JButton("ok");
		okButt.addActionListener(this);
		this.add(okButt, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		parent.setVisible(false);
		this.setVisible(false);
	}
}
