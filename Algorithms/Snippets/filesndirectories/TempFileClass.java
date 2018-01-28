package filesndirectories;

import java.io.File;
import java.io.IOException;

public class TempFileClass {

	public static void main(String[] args) throws IOException {
		createTempFile("foobar", "txt");
	}

	public static File createTempFile(String name, String suffix) {
		try {
			File temp = File.createTempFile(name, "." + suffix);

			temp.deleteOnExit();
			return temp;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}