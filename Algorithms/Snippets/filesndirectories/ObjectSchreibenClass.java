package filesndirectories;

import java.io.*;
import java.util.ArrayList;

public class ObjectSchreibenClass {

	private static String datnam = "myObjs.ser";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList<String> objArrList = null;
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(datnam));
			objArrList = (ArrayList<String>) in.readObject();
		} catch (FileNotFoundException ex) {
			System.out.println("Speichersdatei (noch) nicht vorhanden!");
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
			}
		}
		if (objArrList == null)
			objArrList = new ArrayList<String>();

		objArrList.add(new String("ArrayListgroesse: " + objArrList.size()));
		System.out.println(objArrList);

		ObjectOutputStream aus = null;
		try {
			aus = new ObjectOutputStream(new FileOutputStream(datnam));
			aus.writeObject(objArrList);
		} catch (IOException ex) {
			System.out.println(ex);
		} finally {
			try {
				if (aus != null) {
					aus.flush();
					aus.close();
				}
			} catch (IOException e) {
			}
		}
	}
}