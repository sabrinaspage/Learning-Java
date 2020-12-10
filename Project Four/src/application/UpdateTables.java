package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTables {
	// ------------------------------------------------------------
	// Update Students Table
	// ------------------------------------------------------------
	public static void updateStudentsTable(Connection conn) {
		PreparedStatement students_stmt = null;
		try {
			// create the tables and show the table structure
			String result = "UPDATE Students SET email='demo@gmail.com' WHERE emplID=23771571";
			students_stmt = conn.prepareStatement(result);
			students_stmt.execute();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	// ------------------------------------------------------------
	// Update Courses Table
	// ------------------------------------------------------------
	public static void updateCoursesTable(Connection conn) {
		PreparedStatement courses_stmt = null;
		try {
			// create the tables and show the table structure
			String result = "UPDATE Courses SET courseTitle='Adv Calc' WHERE courseID=34600";
			courses_stmt = conn.prepareStatement(result);
			courses_stmt.execute();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	// ------------------------------------------------------------
	// Update Classes Table
	// ------------------------------------------------------------
	public static void updateClassesTable(Connection conn) {
		PreparedStatement classes_stmt = null;
		try {
			// create the tables and show the table structure
			String result = "UPDATE Classes SET grade='W' WHERE studentID=4";
			classes_stmt = conn.prepareStatement(result);
			classes_stmt.execute(result);
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}