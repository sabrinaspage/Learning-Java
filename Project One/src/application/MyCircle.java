package application;

import java.lang.Math;
import javafx.scene.canvas.GraphicsContext;

class MyCircle extends MyShape {
	private double r;
	
	MyCircle(double xCenter, double yCenter, double r, MyColor fill) {
		super(xCenter, yCenter, fill);
		this.r = r;
	}

	// returns area of MyCircle with area formula

	public double getArea() {
		return Math.PI * Math.pow(getRadius(), 2);
	}

	// perimeter = circumference formula
	
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * getRadius();
	}

	// returns radius of MyCircle

	public double getRadius() {
		return r;
	}

	// string representation of MyCircle object:
	// radius, perimeter, area

	@Override
	public String toString() {
		return "radius: " + getRadius() + "\nPerimeter: " + getPerimeter() + "\narea: " + getArea() + "\n";
	}
	
	// fill the oval with a color
	// stroke it with x and y, height and width
	// height and width are twice the radius

	@Override
	public void draw(GraphicsContext gc) {
		gc.fillOval(super.getX(), super.getY(), getRadius()*2, getRadius()*2);
		gc.strokeOval(super.getX(), super.getY(), getRadius()*2, getRadius()*2);
		gc.setFill(super.getColor().getARGB());
	}
}