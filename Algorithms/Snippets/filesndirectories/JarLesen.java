package filesndirectories;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarLesen {

	public JarLesen() {
		String path = "meineJar.jar";
		JarFile jFile = null;
		JarEntry jEntry = null;
		Entry<?, ?> entry = null;
		try {
			jFile = new JarFile(path);

			Enumeration<JarEntry> jEntries = jFile.entries();
			while (jEntries.hasMoreElements()) {
				jEntry = jEntries.nextElement();
				System.out.println(jEntry.getName());
			}

			Set<?> set = jFile.getManifest().getMainAttributes().entrySet();
			Iterator<?> it = set.iterator();
			while (it.hasNext()) {
				entry = (Entry<?, ?>) (it.next());
				System.out.println(entry);
				String key = entry.getKey().toString();
				String value = entry.getValue().toString();
				System.out.println("Key: " + key + ", Value: " + value + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new JarLesen();
	}
}