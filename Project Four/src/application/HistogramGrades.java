package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class HistogramGrades {
	ResultSet rSet = null;
	Connection conn = null;

	private int totalCharacters = 0;
	private int totalEvents = 0;
	String str = "";
	// create a hashmap containing characters
	// as a key and occurrences as a value
	HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

	{
		try {
			// connect to DB
			conn = DriverManager.getConnection(CONSTANTS.url, CONSTANTS.username, CONSTANTS.password);

			//
			PreparedStatement stmt = conn
					.prepareStatement("SELECT * FROM CLASSES " + "WHERE (semester = 'fall') AND (courseID = 22100)");
			ResultSet rSet = stmt.executeQuery();

			while (rSet.next()) {
				String name = rSet.getString("grade");
				str += name;
			}

			// convert given string to character array

			char[] strArray = str.toCharArray();

			// check each char of strArray
			for (char c : strArray) {
				if (charCountMap.containsKey(c)) {
					// if char is present in charCountMap, increment its count by 1
					charCountMap.put(c, charCountMap.get(c) + 1);
				} else {
					// if char is not present in charCountMap, place it with 1 as start
					charCountMap.put(c, 1);
				}
			}

			// increment total events and total characters by going through the hashmap's
			// entries

			for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
				totalCharacters += entry.getValue();
				totalEvents++;
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public int getTotalEvents() {
		return totalEvents;
	}

	public int getTotalCharacters() {
		return totalCharacters;
	}

	// sort the frequencies by natural order
	public Map<Character, Integer> decreasedFrequency = charCountMap.entrySet().stream()
			.sorted(Map.Entry.<Character, Integer>comparingByKey())
			.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

}