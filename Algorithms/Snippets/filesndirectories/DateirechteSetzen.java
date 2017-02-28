package filesndirectories;

import java.io.File;
import java.io.IOException;

public class DateirechteSetzen {

	public static void main(String[] args) {
		String fileName = "/Users/karlheinzwillipeter/Desktop/test.txt";
		File file = new File(fileName);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (file.setWritable(true, false))
			System.out.println("Dateirechte auf 666 gesetzt.");
	}
}