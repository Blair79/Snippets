package filesndirectories;

import java.io.File;
import java.util.ArrayList;

public class VerzeichnisseSuchen {

	public static ArrayList<File> listDirectories(File root, String dirName, ArrayList<File> list,
			boolean caseSensitivity, boolean printEmpty) {
		if (root == null || dirName.isEmpty()) {
			System.err.println("Ausgangsverzeichnis oder gesuchter Verzeichnisname fehlt!");
			return null;
		}
		if (list == null)
			list = new ArrayList<File>();
		File[] files = root.listFiles();
		if (files.length != 0) {
			for (File file : files) {
				String fileStr = file.toString();
				if (!caseSensitivity) {
					fileStr = fileStr.toLowerCase();
					dirName = dirName.toLowerCase();
				}
				if (fileStr.lastIndexOf(dirName) == fileStr.length() - dirName.length() && file.isDirectory()
						&& file.getName().equalsIgnoreCase(dirName)) {
					list.add(file);
				}
				if (file.isDirectory()) {
					listDirectories(file, dirName, list, caseSensitivity, printEmpty);
				}
			}
		} else if (printEmpty) {
			System.out.println(root + " ist leer!");
		}
		return list;
	}

	public static void main(String[] args) {
		ArrayList<File> list = listDirectories(new File("/home/test"), "leer", null, false, false);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
}