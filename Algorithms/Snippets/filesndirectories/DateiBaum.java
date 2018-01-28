package filesndirectories;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class DateiBaum extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int SHOW_ALL = 0;
	public final static int SHOW_HIDDEN = 1;
	public final static int SHOW_VISIBLE = -1;

	private String path;
	private int showType = SHOW_VISIBLE;
	private JTree tree;

	public DateiBaum(String path) {
		this.path = path;
		tree = new JTree(createModel(this.path));
		tree.addTreeExpansionListener(new TreeExpansionListener() {

			public void treeExpanded(TreeExpansionEvent event) {
				TreePath path = event.getPath();
				FNode node = (FNode) path.getLastPathComponent();
				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
				node.addFiles(showType);
				model.nodeStructureChanged(node);
			}

			public void treeCollapsed(TreeExpansionEvent event) {
			}

		});
		JScrollPane sPane = new JScrollPane(tree);
		this.add(sPane, BorderLayout.CENTER);
		this.add(createButtPanel(), BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setTitle("Datei-Browser");
		this.setVisible(true);
	}

	private DefaultTreeModel createModel(String path) {
		File root = new File(path);
		FNode rootNode = new FNode(root);
		rootNode.addFiles(showType);
		return new DefaultTreeModel(rootNode);
	}

	private JPanel createButtPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		JRadioButton allButt = new JRadioButton("Alle");
		allButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showType = SHOW_ALL;
				tree.setModel(createModel(path));
			}
		});
		JRadioButton hiddenButt = new JRadioButton("Versteckt");
		hiddenButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showType = SHOW_HIDDEN;
				tree.setModel(createModel(path));
			}
		});
		JRadioButton visibleButt = new JRadioButton("Sichtbar", true);
		visibleButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showType = SHOW_VISIBLE;
				tree.setModel(createModel(path));
			}
		});
		ButtonGroup group = new ButtonGroup();
		group.add(allButt);
		group.add(hiddenButt);
		group.add(visibleButt);
		panel.add(allButt);
		panel.add(hiddenButt);
		panel.add(visibleButt);
		return panel;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static void main(String[] args) {
		new DateiBaum(System.getProperty("user.home"));
	}
}

class FNode extends DefaultMutableTreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FNode(File file) {
		setUserObject(file);
	}

	public File getFile() {
		return (File) getUserObject();
	}

	public boolean getAllowsChildren() {
		return getFile().isDirectory();
	}

	public boolean isLeaf() {
		return !getFile().isDirectory();
	}

	public String toString() {
		return getFile().getName();
	}

	public void addFiles(int showHidden) {
		File[] files = getFile().listFiles();
		for (File f : files) {
			if (showHidden == DateiBaum.SHOW_HIDDEN) {
				if (f.isHidden())
					this.add(new FNode(f));
			} else if (showHidden == DateiBaum.SHOW_VISIBLE) {
				if (!f.isHidden())
					this.add(new FNode(f));
			} else {
				this.add(new FNode(f));
			}
		}
	}
}