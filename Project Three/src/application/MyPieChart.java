package application;

import javafx.scene.canvas.GraphicsContext;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class MyPieChart extends MyShape {
	private double probability;
	private HistogramAlphaBet alphabet;
	private int n; // number of events

	public MyPieChart(MyPoint ref, MyColor color, int n, HistogramAlphaBet alphabet) {
		super(ref, color);
		this.n = n;
		this.alphabet = alphabet;
	}

	public void draw(GraphicsContext gc) {
		Iterator<Map.Entry<Character, Integer>> it = alphabet.decreasedFrequency.entrySet().iterator();
		DecimalFormat round = new DecimalFormat("#.####"); // this is to make 4 digit decimals

		// angle starts at 0
		double startingAngle = 0;
		
		//other probabilities start at 1
		double r = 1; 
		
		// for incrementation of arc in and out of n probable events
		int i = 0;

		while (i < n) {
			Map.Entry<Character, Integer> m = it.next();
			int frequency = m.getValue();

			// as value is received, probability is returned

			probability = (double) frequency / alphabet.getTotalCharacters();

			// r value gets subtracted. will be used for other letters
			r -= probability;

			// select a random MyColor constant

			Random rand = new Random();
			MyColor randomColor = MyColor.values()[rand.nextInt(MyColor.values().length)];
			
			String text=m.getKey() + " : " + round.format((double) m.getValue() / alphabet.getTotalCharacters());

			// create a new arc for said color and its probability
			MyArc arc = new MyArc(CONSTANTS.BASIS, randomColor, CONSTANTS.OVAL_BASIS, CONSTANTS.BASIS, startingAngle, probability*360, text, i);
			// draw ot
			arc.draw(gc);
			// add ontot he starting angle
			startingAngle += probability * 360;
			i++;
			
			System.out.println(arc.toString());
		}

		if (n != 26) {
			MyArc arc = new MyArc(CONSTANTS.BASIS, MyColor.LIGHT_GRAY, CONSTANTS.OVAL_BASIS, CONSTANTS.BASIS, startingAngle, r*360, "All other probabilities: " + round.format(r), i);
			arc.draw(gc);
			System.out.println(arc.toString());
		}

	}

	// bounding rectangle
	@Override
	public MyRectangle getBoundingRectangle(MyColor color) {
		return new MyRectangle(super.getRef(), super.getColor(), 0, 0);
	}

	// area of chart
	@Override
	public double getMyArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	// info about chart
	@Override
	public String toString() {
		return String.format("The amount of characters in Emma: " + alphabet.getTotalCharacters() + "\nThe number of events requested is: " + n);
	}
}