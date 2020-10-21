package application;

import javafx.scene.canvas.GraphicsContext;

class MyShape {
	double x, y;
	MyColor shape;

	// constructor
	MyShape(double x, double y, MyColor shape) {
		this.x = x;
		this.y = y;
		this.shape = shape;
	}
	
	// set val for x

	public void setX(int x) {
		this.x = x;
	}
	
	// set val for y

	public void setY(int y) {
		this.y = y;
	}

	// set color based on enum MyColor shapes
	public void setColor(MyColor shape) {
		this.shape = shape;
	}

	// get returned value of x
	public double getX() {
		return x;
	}
	
	// get returned value of y

	public double getY() {
		return y;
	}
	
	// get returned value of colors
	
	public MyColor getColor() {
		return shape;
	}
	
	// my shape has no area because
	// it is just a single coordinate

	public double getArea() {
		return 0;
	}
	
	// again, just a single coordinate, no vals exist yet

	public double getPerimeter() {
		return 0;
	}
	
	// string which states info about MyShape
	// will be overridden in each code
	// in order to define a behavior specific to a subclass type

	public String toString() {
		return "This is MyShape Object. Its perimeter is: " + getPerimeter() + " and its area is: " + getArea()
				+ " with a color of: " + getColor();
	}
	
	// fill with the color assigned
	// and fill the rectangle with vals up to x and y

	public void draw(GraphicsContext gc) {
		gc.setFill(getColor().getARGB());
		gc.fillRect(0, 0, this.x, this.y);
	}
}
