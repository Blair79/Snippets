package filesndirectories;

import java.io.File;
import java.io.IOException;

public class VerzeichnisErstellen {

	public static void main(String[] args) throws IOException {
		String path = "/Users/joecze/Desktop/";
		String fileName = "test.txt";
		String dirName = "bums";
		File file = new File(path + dirName + "/" + fileName);
		File dir = new File(path + dirName);

		if (dir.mkdir()) {
			System.out.println("Datei erstellt: " + file.createNewFile());
		} else {
			System.out.println(dir + " konnte nicht erstellt werden");
		}
	}
}