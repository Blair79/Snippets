package datentime;

import java.io.File;
import java.text.SimpleDateFormat;

public class DatumFormatieren {

	public DatumFormatieren() {

		String className = getClass().getName();
		className = className.replace('.', '/');
		File file = new File(System.getProperty("user.dir") + "/src/" + className + ".java");

		SimpleDateFormat formatter = new SimpleDateFormat();
		System.out.println(formatter.format(file.lastModified()));
	}

	public static void main(String[] args) {
		new DatumFormatieren();
	}
}