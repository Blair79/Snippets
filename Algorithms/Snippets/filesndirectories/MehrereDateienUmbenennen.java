package filesndirectories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import javax.swing.JOptionPane;

public class MehrereDateienUmbenennen {

	private void renameFile(String pfad, String postfix, String extension, boolean ask, boolean delete, int deepness) {
		if (postfix == null) {
			postfix = "";
		}
		File file = new File(pfad);
		if (file.isDirectory()) {
			if (--deepness > -1) {
				File[] files = file.listFiles();
				for (File f : files) {
					renameFile(f.getAbsolutePath(), postfix, extension, ask, delete, deepness);
				}
			}
		} else if (file.canWrite()) {
			String extOld = pfad.substring(pfad.lastIndexOf(".") + 1, pfad.length());
			if (extension == null) {
				extension = extOld;
				delete = false;
			}
			pfad = pfad.substring(0, pfad.lastIndexOf(".")) + postfix + "." + extension;
			int conf = -1;
			if (ask) {
				conf = JOptionPane.showConfirmDialog(null, "Soll die Datei " + file.getName() + " umbenannt werden?",
						"Best\u00E4tigung", JOptionPane.YES_NO_OPTION);
			}
			if (conf == JOptionPane.YES_OPTION || !ask) {
				copyFile(file, new File(pfad));
				if (delete) {
					file.delete();
				}
			}
		} else {
			if (file.setWritable(true)) {
				renameFile(file.getAbsolutePath(), postfix, extension, ask, delete, deepness);
			} else {
				System.err.println("Anpassung der Schreibberechtigungen von " + file.getName() + "nicht m\u00F6glich!");
				return;
			}
		}
	}

	public static void copyFile(File in, File out) {
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			inChannel = new FileInputStream(in).getChannel();
			outChannel = new FileOutputStream(out).getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inChannel != null)
					inChannel.close();
				if (outChannel != null)
					outChannel.close();
			} catch (IOException e) {
			}
		}
	}

	public static void main(String[] args) {
		String pfad = "/Users/joecze/test/";
		MehrereDateienUmbenennen mdu = new MehrereDateienUmbenennen();
		mdu.renameFile(pfad, null, "html", false, false, 2);
	}
}