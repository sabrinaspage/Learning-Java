package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class HistogramAlphaBet {
	private File file =  new File("C:\\Users\\sabri\\eclipse-workspace\\AssignmentThree\\src\\application\\Emma.txt");

	// arraylist collects the letters from the file
    private ArrayList<String> line = new ArrayList<>();
    // hashmap gets the frequencies in a certain order
    private HashMap<Character, Integer> frequency = new HashMap<>();
    // scans through the text with scanner in
    private String read;
    // gets value/length of all the characters
    private int totalCharacters = 0;
    Scanner in;
    {
        try {
            in = new Scanner(file);
            // while in still has values to go through
            while (in.hasNext()){
            	// replace all the values with the regex, anything that is not a-zA-Z
                read =in.next().replaceAll ("[^a-zA-Z]", "");
                // add those values to the arraylist while lowercase
                line.add(read.toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // close scanner
        in.close();

        for (int i = 0; i < line.size(); i++){
            for (char c: line.get(i).toCharArray()){
            	// add up the total characters
                // and also place
                totalCharacters++;
                if (!frequency.containsKey(c)) frequency.put(c, 1);
                else frequency.put (c, frequency.get(c) + 1);
            }
        }
    }

	public int getTotalCharacters() {
		return totalCharacters;
	}

	// sort the frequencies in decreasing order
	Map<Character, Integer> decreasedFrequency = frequency.entrySet().stream()
			.sorted(comparingByValue(Comparator.reverseOrder()))
			.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

}