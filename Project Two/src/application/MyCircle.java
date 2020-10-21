package application;

import javafx.scene.canvas.GraphicsContext;

public class MyCircle extends MyOval {
	private double r; // radius

	public MyCircle(MyPoint p, MyColor color, double r) {
		super(p, color, Math.pow(r, 2), Math.pow(r, 2));
		this.r = r;
	}
	
	// constructor with super class and radius
	
	public double getDiameter() {
		return this.r * 2;
	}
	
	// return diameter of circle

	public double getArea() {
		return Math.PI * Math.pow(r, 2);
	}
	
	// return area of circle, which is pi * radius squared

	public double getRadius() {
		return this.r;
	}
	
	// return radius of circle

	public double getPerimeter() {
		return 2 * Math.PI * this.r;
	}
	
	// return perimeter of circle, which is 2 * pi * radius

	@Override
	public String toString() {
		return String.format("ref pt: " + super.getRef() + "radius: " + getRadius() + "perimeter: " + getPerimeter()
				+ "area: " + getArea() + "color: " + super.getColor());
	}
	
	// return the string with information about circle

	@Override
	public void draw(GraphicsContext gc) {
		gc.setStroke(super.getColor().getARGB());
		gc.strokeOval(super.getRef().getX(), super.getRef().getY(), getDiameter(), getDiameter());
		gc.setFill(super.getColor().getARGB());
		gc.fillOval(super.getRef().getX(), super.getRef().getY(), getDiameter(), getDiameter());
	}
	
	// draw an overridden context canvas
	// filling in the strokes and creating an oval
}