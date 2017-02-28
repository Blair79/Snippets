package jOpenDocument;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class Create_a_spreadsheet {

	public static void main(String[] args) {
		// Create the data to save.
		final Object[][] data = new Object[6][2];
		data[0] = new Object[] { "January", 1 };
		data[1] = new Object[] { "February", 3 };
		data[2] = new Object[] { "March", 8 };
		data[3] = new Object[] { "April", 10 };
		data[4] = new Object[] { "May", 15 };
		data[5] = new Object[] { "June", 18 };

		String[] columns = new String[] { "Month", "Temp" };

		TableModel model = new DefaultTableModel(data, columns);

		// Save the data to an ODS file and open it.
		final File file = new File("C:\\Users\\ColBl\\Desktop\\temperature.ods");
		try {
			SpreadSheet.createEmpty(model).saveAs(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * try { OOUtils.open(file); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}

}
