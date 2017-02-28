package filesndirectories;

import java.io.File;

public class Dateigroesse {

	public static void main(String[] args) {
		File f = new File("test.jpg");
		double fileSize = f.length() / 1024d;
		System.out.println(fileSize + "kb");
	}
}