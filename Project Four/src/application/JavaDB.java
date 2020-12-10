package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

// ------------------------------------------
// interaction between Java program and a database
// Name: Sabrina Reyes
// ------------------------------------------

public class JavaDB {
	// ---------------------------------------
	// carries out CRUD operations after establishing database
	// connection
	// ---------------------------------------
	public static void connect() {
		Connection conn = null;
		try {

			// loads class object for mysql driver into DriverManager
			Class.forName(CONSTANTS.driver);

			// attempt to establish a connection to the specified database via the
			// drivermanager
			conn = DriverManager.getConnection(CONSTANTS.url, CONSTANTS.username, CONSTANTS.password);

			// check for connection
			if (conn != null) {
				System.out.println("We have connected to our database!\n");

				System.out.println("\nInformation about Students Table: \n");
				CreateTables.createStudentsTable(conn);
				AddTables.addStudents(conn);
				// UpdateTables.updateStudentsTable(conn);
				JavaDB.showValues(conn, "Students");

				System.out.println("\nInformation about Courses Table: \n");
				CreateTables.createCoursesTable(conn);
				AddTables.addCourses(conn);
				// UpdateTables.updateCoursesTable(conn);
				JavaDB.showValues(conn, "Courses");

				System.out.println("\nInformation about Classes Table: \n");
				CreateTables.createClassesTable(conn);
				// AddTables.addClasses(conn);
				UpdateTables.updateClassesTable(conn);
				JavaDB.showValues(conn, "Classes");
				
				System.out.println("\nOccurrences of Grade per Student in CSC 22100 during the Fall 2020 Semester from Classes Table: \n");
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM CLASSES " + "WHERE semester = 'fall' AND " + "courseID = 22100");
				ResultSet rset = stmt.executeQuery();
				CharacterPrint.characterPrint(rset);
				
				conn.close();
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		} catch (Exception exc) {
			System.out.println("Exception: " + exc.getMessage());
			exc.printStackTrace();
		}
	}

	// ------------------------------------------------------------
	// Obtains and displays the resultset from a table
	// ------------------------------------------------------------

	public static void showValues(Connection conn, String columnName) {
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			stmt = conn.prepareStatement("SELECT * FROM " + columnName);
			rset = stmt.executeQuery();
			JavaDB.showResults(columnName, rset);
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	// ------------------------------------------------------------
	// Displays the structure of a table
	// ------------------------------------------------------------

	public static void showColumns(Connection conn, String columnName) {
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			stmt = conn.prepareStatement("SHOW COLUMNS FROM " + columnName);
			rset = stmt.executeQuery();
			JavaDB.showResults(columnName, rset);
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	// ------------------------------------------------------------
	// Displays the contents of the specified result set
	// ------------------------------------------------------------

	public static void showResults(String tableName, ResultSet rSet) {
		try {
			ResultSetMetaData rsmd = rSet.getMetaData();
			int numColumns = rsmd.getColumnCount();
			String resultString = null;

			// if there are more than 0 columns
			if (numColumns > 0) {
				// create a table string
				resultString = "Table: " + tableName + "\n" + "=====================================================\n";
				// fill the result string with the labels you want to place on the header
				for (int colNum = 1; colNum <= numColumns; colNum++)
					resultString += rsmd.getColumnLabel(colNum) + "\t";
			}
			System.out.println(resultString);
			System.out.println("=====================================================");
			// while there is a next row
			while (rSet.next()) {
				resultString = "";
				for (int colNum = 1; colNum <= numColumns; colNum++) {
					// get the column string you want to fill for that row
					String column = rSet.getString(colNum);
					// if it exists, then fill it will the string of that column
					if (column != null)
						resultString += column + "\t\t";
				}
				System.out.println(resultString);
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}