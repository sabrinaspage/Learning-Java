package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTables {
	// add students
		public static void addStudents(Connection conn) {
			PreparedStatement students_stmt = null;

			try {
				// Insert the data into the database and show the values in the table
				String rowCount = "REPLACE INTO Students "
						+ "(emplID, firstName, lastName, email, sex) VALUES (23771569, \"Feechi\", \"Conteh\", \"feechiconteh2@gmail.com\", \"M\")";
				students_stmt = conn.prepareStatement(rowCount);
				students_stmt.executeUpdate();

				String rowCount2 = "REPLACE INTO Students "
						+ "(emplID, firstName, lastName, email, sex) VALUES (23771570, \"Aanya\", \"Ahuja\", \"aanyaahuja1@gmail.com\", \"F\")";
				students_stmt = conn.prepareStatement(rowCount2);
				students_stmt.executeUpdate();
				
				String rowCount3 = "REPLACE INTO Students "
						+ "(emplID, firstName, lastName, email, sex) VALUES (23771571, \"Ana\", \"Cruz\", \"anacruz@gmail.com\", \"F\")";
				students_stmt = conn.prepareStatement(rowCount3);
				students_stmt.executeUpdate();
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				ex.printStackTrace();
			}
		}

		// add courses

		public static void addCourses(Connection conn) {
			PreparedStatement courses_stmt = null;

			try {
				// Insert the data into the database and show the values in the table
				String rowCount = "REPLACE INTO Courses "
						+ "(courseId, courseTitle, department) VALUES (22100, \"Soft Des Lab\", \"Computer Science\")";
				courses_stmt = conn.prepareStatement(rowCount);
				courses_stmt.executeUpdate();

				String rowCount2 = "REPLACE INTO Courses "
						+ "(courseId, courseTitle, department) VALUES (10100, \"Intro to Pol Sc\", \"History\")";
				courses_stmt = conn.prepareStatement(rowCount2);
				courses_stmt.executeUpdate();

				String rowCount3 = "REPLACE INTO Courses "
						+ "(courseId, courseTitle, department) VALUES (34600, \"Linear Algebra\",  \"Mathematics\")";
				courses_stmt = conn.prepareStatement(rowCount3);
				courses_stmt.executeUpdate();

				String rowCount4 = "REPLACE INTO Courses "
						+ "(courseId, courseTitle, department) VALUES (10200, \"Biology 2\", \"Biology\")";
				courses_stmt = conn.prepareStatement(rowCount4);
				courses_stmt.executeUpdate();

				String rowCount5 = "REPLACE INTO Courses "
						+ "(courseId, courseTitle, department) VALUES (20200, \"Intro to Arch\", \"Architecture\")";
				courses_stmt = conn.prepareStatement(rowCount5);
				courses_stmt.executeUpdate();

			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				ex.printStackTrace();
			}
		}

		// add classes

		public static void addClasses(Connection conn) {
			PreparedStatement classes_stmt = null;
			try {
				// Insert the data into the database and show the values in the table
				String rowCount = "REPLACE INTO Classes "
						+ "(courseID, sectionNo, year, semester, grade) VALUES (22100, 1, 2020, '1', 'A')";
				classes_stmt = conn.prepareStatement(rowCount);
				classes_stmt.executeUpdate();

				String rowCount2 = "REPLACE INTO Classes "
						+ "(courseID, sectionNo, year, semester, grade) VALUES (22100, 2, 2020, '2', 'W')";
				classes_stmt = conn.prepareStatement(rowCount2);
				classes_stmt.executeUpdate();

				String rowCount3 = "REPLACE INTO Classes "
						+ "(courseID, sectionNo, year, semester, grade) VALUES (22100, 1, 2020, '1', 'B')";
				classes_stmt = conn.prepareStatement(rowCount3);
				classes_stmt.executeUpdate();

				String rowCount4 = "REPLACE INTO Classes "
						+ "(courseID, sectionNo, year, semester, grade) VALUES (10100, 2, 2020, '1', 'B')";
				classes_stmt = conn.prepareStatement(rowCount4);
				classes_stmt.executeUpdate();

				String rowCount5 = "REPLACE INTO Classes "
						+ "(courseID, sectionNo, year, semester, grade) VALUES (22100, 2, 2020, '1', 'C')";
				classes_stmt = conn.prepareStatement(rowCount5);
				classes_stmt.executeUpdate();

				String rowCount6 = "REPLACE INTO Classes "
						+ "(courseID, sectionNo, year, semester, grade) VALUES (21100, 2, 2020, '2', 'C')";
				classes_stmt = conn.prepareStatement(rowCount6);
				classes_stmt.executeUpdate();

				String rowCount7 = "REPLACE INTO Classes "
						+ "(courseID, sectionNo, year, semester, grade) VALUES (22100, 1, 2020, '1', 'D')";
				classes_stmt = conn.prepareStatement(rowCount7);
				classes_stmt.executeUpdate();

				String rowCount8 = "REPLACE INTO Classes "
						+ "(courseID, sectionNo, year, semester, grade) VALUES (22100, 1, 2020, '2', 'F')";
				classes_stmt = conn.prepareStatement(rowCount8);
				classes_stmt.executeUpdate();

				String rowCount9 = "REPLACE INTO Classes "
						+ "(courseID, sectionNo, year, semester, grade) VALUES (21100, 1, 2020, '1', 'B')";
				classes_stmt = conn.prepareStatement(rowCount9);
				classes_stmt.executeUpdate();

				String rowCount10 = "REPLACE INTO Classes "
						+ "(courseID, sectionNo, year, semester, grade) VALUES (22100, 2, 2019, '1', 'F')";
				classes_stmt = conn.prepareStatement(rowCount10);
				classes_stmt.executeUpdate();
				
				String rowCount11 = "REPLACE INTO Classes "
						+ "(courseID, sectionNo, year, semester, grade) VALUES (22100, 2, 2020, '1', 'A')";
				classes_stmt = conn.prepareStatement(rowCount11);
				classes_stmt.executeUpdate();
				
				String rowCount12 = "REPLACE INTO Classes "
						+ "(courseID, sectionNo, year, semester, grade) VALUES (22100, 2, 2020, '1', 'B')";
				classes_stmt = conn.prepareStatement(rowCount12);
				classes_stmt.executeUpdate();
				
				String rowCount13 = "REPLACE INTO Classes "
						+ "(courseID, sectionNo, year, semester, grade) VALUES (22100, 2, 2020, '1', 'A')";
				classes_stmt = conn.prepareStatement(rowCount13);
				classes_stmt.executeUpdate();
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				ex.printStackTrace();
			}
		}	
}
