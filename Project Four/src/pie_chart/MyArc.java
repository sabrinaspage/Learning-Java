package pie_chart;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class MyArc extends MyShape {
	private MyPoint coordinate;
	private MyOval basis;
	private double probability;
	private double startAngle;
	private String text;
	private int i;

	public MyArc(MyPoint ref, MyColor color, MyOval basis, MyPoint coordinate, double startAngle, double probability, String text, int i) {
		super(ref, color);
		this.basis = basis;
		this.coordinate = coordinate;
		this.startAngle = startAngle;
		this.probability = probability;
		this.text = text;
		this.i = i;
	}

	// return the types as given

	public MyPoint getCoordinate() {
		return this.coordinate;
	}

	public MyOval getBasis() {
		return this.basis;
	}

	public double getStartAngle() {
		return this.startAngle;
	}

	
	public double getProbability() {
		return this.probability;
	}
	
	public String getText() {
		return this.text;
	}
	
	public int geti() {
		return this.i;
	}
	
	// text describing the arc
	public void setText(String text) {
		this.text = text;
	}
	
	// for legend
		public void setI(int i) {
			this.i = i;
		}
	
	// angle of the starting arc
	public void setProbability(double probability) {
		this.probability = probability;
	}

	// angle of the starting arc
	public void setStartAngle(double startAngle) {
		this.startAngle = startAngle;
	}

	// the coordinate which the arc surrounds
	public void coordinate(MyPoint coordinate) {
		this.coordinate = coordinate;
	}

	// arc is a segment of a MyOval object
	// so this is the MyOval object itself
	public void setBasis(MyOval basis) {
		this.basis = basis;
	}

	public void draw(GraphicsContext gc) {		
		gc.setFill(this.getColor().getARGB());
		gc.setLineWidth(1);
		gc.fillText(text, 350, 30*i + 30);
        gc.strokeArc(coordinate.getX(), coordinate.getY(), basis.getWidth() / 2, basis.getHeight() / 2, this.startAngle, this.probability, ArcType.ROUND);
        gc.fillArc (coordinate.getX(), coordinate.getY(), basis.getWidth() / 2, basis.getHeight() / 2, this.startAngle, this.probability, ArcType.ROUND);
	}
	
	// info about arc

	@Override
	public String toString() {
		return String.format(
				"Start coordinate for angle: (%f, %f); \nWidth: %f \nHeight: %f \nArc starting angle: %f \nArc spacing: %f",
				coordinate.getX(), coordinate.getY(), basis.getWidth() / 2, basis.getHeight() / 2, this.startAngle, this.probability * 360);
	}

	
	// get bounding rectangle by applying full height and width
	@Override
	public MyRectangle getBoundingRectangle(MyColor color) {
		return new MyRectangle(super.getRef(), color, basis.getHeight() / 2, basis.getWidth() / 2);
	}

	@Override
	public double getMyArea() {
		// get with the radius
		if (basis.getHeight() == basis.getWidth()) {
			return ((this.probability * 360) / basis.getRadius()) / (2 * Math.PI);
		}
		return 0;
	}
}