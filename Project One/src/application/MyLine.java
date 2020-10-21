package application;

import javafx.scene.canvas.GraphicsContext;

class MyLine extends MyShape {
	private double x1, y1; // The x and y coordinates of one end of the line
	private double x2, y2; // the x and y coordinates of the other end of the line
	private int strokeWidth = 5;
	private MyColor line;

	// constructor 
	MyLine(double x1, double y1, double x2, double y2, MyColor line) {

		super((int)x1, (int)x2, line);
		
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.line = line;
	}

	// angle with the x-axis in degrees
	public double get_xAngle() {
		return Math.toDegrees(Math.atan((double) (y2 - y1) / (double) (x2 - x1)));
	}
	
	// set width of stroke
	
	public void setStrokeWidth(int strokeWidth) {
		this.strokeWidth = strokeWidth;
	}
	
	// get width of stroke
	
	public int getStrokeWidth() {
		return strokeWidth;
	}
	// length of line is the distance formula between two points
	
	public int getLength() {
		return (int) (Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)));
	}
	
	// set color of line based on enum MyColor type
	
	public MyColor getColor() {
		return line;
	}
	
	// override as it is a subclass

	@Override
	// area = 0
	public double getArea() {
		return 0;
	}

	@Override
	// perimeter = length
	public double getPerimeter() {
		return getLength();
	}
	
	// string which described angle and length of line

	@Override
	public String toString() {
		return "Line: [(" + x1 + "," + x2 + "), (" + x1 + "," + x2 + ")] Length: " + getLength() + " and angle:"
				+ get_xAngle();
	}
	
	// draw the line with its width
	// a stroke of a certain color
	// and the line itself

	@Override
	public void draw(GraphicsContext gc) {
		gc.setLineWidth(getStrokeWidth());
		gc.setStroke(getColor().getARGB());
		gc.strokeLine(this.x1, this.y1, this.x2, this.y2);
	}
}