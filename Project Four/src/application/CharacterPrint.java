package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CharacterPrint {
	public static void characterPrint (ResultSet rSet) {
		String str = "";
		int totalCharacters = 0;
		try {
			// create a hashmap containing characters
			// as a key and occurrences as a value
			
			HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
			while(rSet.next()) {
				String name = rSet.getString("grade");
				str += name;
			}
			
			// convert given string to character array
			
			char[] strArray = str.toCharArray();
			
			// check each char of strArray
			for (char c: strArray) {
				if (charCountMap.containsKey(c)) {
					// if char is present in charCountMap, increment its count by 1
					charCountMap.put(c, charCountMap.get(c) + 1);
				} else {
					// if char is not present in charCountMap, place it with 1 as start
					charCountMap.put(c, 1);
				}
			}
			
			// printing the charCountap
			System.out.println("Character \tStudents");
			for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
				System.out.println("--------------------------------");
				System.out.println(entry.getKey() + "\t\t" + entry.getValue());
				totalCharacters += entry.getValue();
			}
			System.out.println("--------------------------------");
			System.out.println("Total Students: " + totalCharacters);
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}