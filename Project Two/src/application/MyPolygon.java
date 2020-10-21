package application;

import javafx.scene.canvas.GraphicsContext;

public class MyPolygon extends MyShape {
	private double r;
	private int sides;
	private double x[], y[];

	MyPolygon(MyPoint p, MyColor color, double radius, int sides) {
		super(p, color);
		this.sides = sides;
		x = new double[sides];
		y = new double[sides];
		double angle = (2 * Math.PI) / sides;
		for (int i = 0; i < sides; ++i) {
			x[i] = super.getRef().getX() + (radius * (-1 * Math.sin(i * angle)));
			y[i] = super.getRef().getY() + (radius * (-1 * Math.cos(i * angle)));
		}
	}

	public double getArea() {
		return Math.pow(r, 2) * sides * Math.sin(getAngle()) * 0.5;
	}

	public double getPerimeter() {
		return sides * getSide();
	}

	public double getAngle() {
		return Math.PI / sides;
	}

	public double getSide() {
		return 2 * r * Math.sin(Math.PI / sides);
	}

	@Override
	public String toString() {
		return String.format("Reference:", super.getRef(), "Radius:", getRadius(), "Area:", getArea(), "Perimeter:",
				getPerimeter(), "Angle:", getAngle(), "Apothem:", getApothem(), "Color:", super.getColor());
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(super.getColor().getARGB());
		gc.setStroke(super.getColor().getARGB());
		gc.setLineWidth(3);
		gc.strokePolygon(x, y, sides);
		gc.fillPolygon(x, y, sides);
		gc.setStroke(super.getColor().getARGB());
		for (int i = 1; i < sides; ++i) {
			gc.strokeLine(x[i - 1], y[i - 1], x[i], y[i]);
		}
		gc.strokeLine(x[sides - 1], y[sides - 1], x[0], y[0]);
	}
	
	public double getApothem() {
		return r * Math.cos(Math.toRadians((180 / (double) sides)));
	}

	public double getRadius() {
		return r;
	}

	@Override
	public MyRectangle getBoundingRectangle(MyColor c) {
		if (this.sides == 3)
			return new MyRectangle(
					new MyPoint(
							super.getRef().getX() - (Math.sqrt(Math.pow(this.r, 2) - Math.pow(getApothem(), 2))),
							super.getRef().getY() - this.r),
					c, this.r + getApothem(),
					(Math.sqrt(Math.pow(this.r, 2) - Math.pow(getApothem(), 2))) * 2);
		if ((this.sides & 1) != 0)
			return new MyRectangle(
					new MyPoint(super.getRef().getX() - this.r, super.getRef().getY() - this.r), c,
					this.r + getApothem(), Math.pow(this.r, 2));
		if (this.sides == 6)
			return new MyRectangle(
					new MyPoint(super.getRef().getX() - getApothem(), super.getRef().getY() - this.r), c,
					Math.pow(this.r, 2), getApothem() + getApothem());
		else
			return new MyRectangle(
					new MyPoint(super.getRef().getX() - this.r, super.getRef().getY() - this.r), c,
					Math.pow(this.r, 2), Math.pow(this.r, 2));
	}

	@Override
	public double getMyArea() {
		return Math.pow(r, 2) * sides * Math.sin(getAngle()) * 0.5;
	}
}