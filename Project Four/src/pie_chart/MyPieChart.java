package pie_chart;

import javafx.scene.canvas.GraphicsContext;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import application.CONSTANTS;
import application.HistogramGrades;

public class MyPieChart extends MyShape {

	private HistogramGrades grades;
	private int area;
	private int n;

	public MyPieChart(MyPoint p, MyColor color, int n, HistogramGrades grades) {
		super(p, color);
		this.n = n;
		this.grades = grades;
	}

	@Override
	public void draw(GraphicsContext gc) {
		Iterator<Map.Entry<Character, Integer>> it = grades.decreasedFrequency.entrySet().iterator();
		DecimalFormat round = new DecimalFormat("#.####"); // this is to make 4 digit decimals

		// starting angle is at 0
		double startingAngle = 0;
		double probability = 0;

		// other probabilities start at 1
		double r = 1;

		// increment but also add to arc later on
		int i = 0;

		// value to present total characters
		int otherChars = grades.getTotalCharacters();

		while (i < n) {
			// it represents the grades as frequency going down
			Map.Entry<Character, Integer> m = it.next();

			// the value of the first event
			int frequency = m.getValue();
			otherChars -= m.getValue();

			// probability is the value of occurrence of a grade out of all the grades
			probability = (double) frequency / grades.getTotalCharacters();

			// subtract probability value from r for the rest
			r -= probability;

			// now get a random color from the colors in MyColor
			Random rand = new Random();
			MyColor randomColor = MyColor.values()[rand.nextInt(MyColor.values().length)];

			String text = m.getKey() + ": " + round.format(probability) + "\t" + m.getValue() + " students";
			MyArc arc = new MyArc(CONSTANTS.BASIS, randomColor, CONSTANTS.OVAL_BASIS, CONSTANTS.BASIS, startingAngle,
					probability * 360, text, i);
			arc.draw(gc);

			area += arc.getMyArea();

			// add onto the startingAngle for the next arc
			startingAngle += probability * 360;
			i++;
		}

		if (n != grades.getTotalCharacters()) {
			MyArc arc = new MyArc(CONSTANTS.BASIS, MyColor.LIGHT_GRAY, CONSTANTS.OVAL_BASIS, CONSTANTS.BASIS,
					startingAngle, r * 360,
					"All other probabilities: " + round.format(r) + "\n\tStudents: " + otherChars, i);
			arc.draw(gc);
		}
	}

	@Override
	public MyRectangle getBoundingRectangle(MyColor color) {
		return new MyRectangle(super.getRef(), super.getColor(), 0, 0);
	}

	@Override
	public double getMyArea() {
		return area;
	}

	@Override
	public String toString() {
		return String.format("The total amount of grades seen on the pie chart is: " + grades.getTotalEvents()
				+ ". The total amount of students with these grades are: " + grades.getTotalCharacters());
	}
}