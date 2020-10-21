package application;

import javafx.scene.canvas.GraphicsContext;

class MyPolygon extends MyShape {
	private int N = 5;
	private double sideLength;
	private double[] xPoints, yPoints;
	
	// constructor

	public MyPolygon(double x, double y, int N, double sideLength, MyColor color) {
		super(x, y, color);
		this.N = N;
		this.sideLength = sideLength;
	}
	
	// return number of sides
	
	public int getNumberOfSides() {
		return N;
	}
	
	// area of regular polygon
	// is the side length squared
	// multiplied with the amount of sides divided by four
	// multiplied with the tangent of radians
	
	@Override
	public double getArea() {
		return Math.pow(getSide(), 2) * this.N / 4 * (Math.tan(Math.toRadians(180 / this.N)));
	}
	
	
	// perimeter of polygon is N sides and the side lengths
	// part of subclass, that is why it can be overridden

	@Override
	public double getPerimeter() {
		return this.N * getSide();
	}
	
	// get interior angle with formula
	// 180 degrees * the amount of side minus two divided by all sides

	public double getAngle() {
		return 180 * (this.N - 2) / this.N;
	}
	
	// get side length

	public double getSide() {
		return sideLength;
	}
	
	@Override
	public String toString() {
		return "Side length:" + getSide() + " \nInterior Angle: " + getAngle() + " \nPerimeter:" + getPerimeter()
				+ " \nArea" + getArea();
	}

	public void draw(GraphicsContext gc) {
		gc.setFill(super.getColor().getARGB());
		xPoints = new double[getNumberOfSides()];
		yPoints = new double[getNumberOfSides()];
		double angle = (this.N - 1) * getAngle();
		double inc = (2 * Math.PI) / getNumberOfSides();
		for (int i = 0; i < getNumberOfSides(); i++) {
			xPoints[i] = (int) ((getSide() * Math.cos(angle)) + super.getX());
			yPoints[i] = (int) ((getSide() * Math.sin(angle)) + super.getY());
			angle += inc;
		}
		gc.strokePolygon(xPoints, yPoints, getNumberOfSides());
		gc.fillPolygon(xPoints, yPoints, getNumberOfSides());
	}
}