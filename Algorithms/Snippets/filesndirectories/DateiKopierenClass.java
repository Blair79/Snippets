package filesndirectories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class DateiKopierenClass {

	public static void main(String[] args) throws IOException {
		File inF = new File("/home/user/inputFile.txt");
		File outF = new File("/home/user/outputFile.txt");
		copyFile(inF, outF);
	}

	@SuppressWarnings("resource")
	public static void copyFile(File in, File out) throws IOException {
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			inChannel = new FileInputStream(in).getChannel();
			outChannel = new FileOutputStream(out).getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			throw e;
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
}