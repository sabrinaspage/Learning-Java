package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTables {
	
	// ------------------------------------------------------------
	// Create Students Table
	// ------------------------------------------------------------
	
	public static void createStudentsTable(Connection conn) {
		PreparedStatement students_stmt = null;
		try {
			// create the tables and show the table structure
			String result = "CREATE TABLE IF NOT EXISTS Students " + " (emplID INT UNSIGNED NOT NULL, "
					+ " PRIMARY KEY (emplID), firstName varchar(255), lastName varchar(255), "
					+ " email varchar(255), sex ENUM('F', 'M', 'U'))";
			students_stmt = conn.prepareStatement(result);
			students_stmt.execute();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	// ------------------------------------------------------------
	// Create Courses Table
	// ------------------------------------------------------------
	
	public static void createCoursesTable(Connection conn) {
		PreparedStatement courses_stmt = null;
		try {
			// create the tables and show the table structure
			String result = "CREATE TABLE IF NOT EXISTS Courses " + " (courseID INT UNSIGNED NOT NULL, "
					+ "PRIMARY KEY (courseID), courseTitle varchar(255), department varchar(255))";
			courses_stmt = conn.prepareStatement(result);
			courses_stmt.execute();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	// ------------------------------------------------------------
	// Create Classes Table
	// ------------------------------------------------------------
	
	public static void createClassesTable(Connection conn) {
		PreparedStatement classes_stmt = null;
		try {
			// create the tables and show the table structure
			String result = "CREATE TABLE IF NOT EXISTS Classes "
					+ "(courseID INT UNSIGNED NOT NULL, studentID INT UNSIGNED NOT NULL AUTO_INCREMENT, sectionNo ENUM('1', '2'), "
					+ "primary key(studentID), year INT UNSIGNED NOT NULL, semester ENUM('fall', 'spring'), grade ENUM('A', 'B', 'C', 'D', 'F', 'W'))";
			classes_stmt = conn.prepareStatement(result);
			classes_stmt.execute(result);
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}