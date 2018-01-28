package openCSV;

import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class openCSV {
	static String csvFilename = "C:\\Users\\ColBl\\Desktop\\data.csv";

	public static void main(String[] args) throws IOException {

		// write();
		// parseCSVLineByLine();
		// parseFullCSVExample();
		// appendToCSVExample();
		// CSVMappedToJavaBeanExample();
		/*
		 * try { databaseEx(); } catch (SQLException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		// beanEx();

	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private static void CSVMappedToJavaBeanExample() throws IOException {
		CsvToBean csv = new CsvToBean();

		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));

		// Set column mapping strategy
		List list = csv.parse(setColumMapping(), csvReader);

		for (Object object : list) {
			Employee employee = (Employee) object;
			System.out.println(employee);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static ColumnPositionMappingStrategy setColumMapping() {
		ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
		strategy.setType(Employee.class);
		String[] columns = new String[] { "id", "firstName", "lastName", "country", "age" };
		strategy.setColumnMapping(columns);
		return strategy;
	}

	@SuppressWarnings("unused")
	private static void write() throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(csvFilename));

		// Create record
		String[] record = "4,David,Miller,Australia,30".split(",");
		// Write the record to file
		writer.writeNext(record);

		// close the writer
		writer.close();
	}

	@SuppressWarnings("unused")
	private static void appendToCSVExample() throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(csvFilename, true));

		String[] record = "3,David,Feezor,USA,40".split(",");

		writer.writeNext(record);

		writer.close();
	}

	@SuppressWarnings("unused")
	private static void parseCSVLineByLine() throws IOException {
		// Build reader instance
		// Read data.csv
		// Default seperator is comma
		// Default quote character is double quote
		// Start reading from line number 2 (line numbers start from zero)
		CSVReader reader = new CSVReader(new FileReader(csvFilename), ',', '"', 0);

		// Read CSV line by line and use the string array as you want
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			if (nextLine != null) {
				// Verifying the read data here
				System.out.println(Arrays.toString(nextLine));
			}
		}
		reader.close();
	}

	@SuppressWarnings("unused")
	private static void parseFullCSVExample() throws IOException {
		// Build reader instance
		CSVReader reader = new CSVReader(new FileReader(csvFilename), ',', '"', 0);

		// Read all rows at once
		List<String[]> allRows = reader.readAll();

		// Read CSV line by line and use the string array as you want
		for (String[] row : allRows) {
			System.out.println(Arrays.toString(row));
		}
		reader.close();
	}

	@SuppressWarnings("unused")
	private static void databaseEx() throws IOException, SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		CSVWriter writer = null;

		String url = "jdbc:mysql://localhost:3306/testdb";
		String user = "blair";
		String password = "Warcraft3@gmx.net";

		try {

			con = DriverManager.getConnection(url, user, password);
			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM cars");
			rs = pst.executeQuery();

			writer = new CSVWriter(new FileWriter("C:\\Users\\ColBl\\Desktop\\cars.csv"));
			writer.writeAll(rs, true);

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {

			if (writer != null) {
				writer.close();
			}

			if (rs != null) {
				rs.close();
			}

			if (pst != null) {
				pst.close();
			}

			if (con != null) {
				con.close();
			}

		}

	}

	@SuppressWarnings("unused")
	private static void beanEx() throws IOException {

		String fileName = "C:\\Users\\ColBl\\Desktop\\cars.csv";

		try (CSVReader reader = new CSVReader(new FileReader(fileName))) {

			HeaderColumnNameMappingStrategy<CarBean> strategy = new HeaderColumnNameMappingStrategy<>();
			strategy.setType(CarBean.class);

			CsvToBean<CarBean> csvToBean = new CsvToBean<>();
			List<CarBean> beanList = csvToBean.parse(strategy, reader);

			for (CarBean bean : beanList) {
				System.out.println(bean);
			}
		}
	}
}
