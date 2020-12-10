package application;

import javafx.scene.canvas.GraphicsContext;

public class MyRectangle extends MyShape {
	private double h, w;

	public MyRectangle(MyPoint p, MyColor color, double h, double w) {
		super(p, color);
		this.h = h;
		this.w = w;
	}

	public double getWidth() {
		return this.w;
	}

	public double getHeight() {
		return this.h;
	}

	public void setWidth(double w) {
		this.w = w;
	}

	public void setHeight(double h) {
		this.h = h;
	}

	public double getPerimeter() {
		return this.w + this.w + this.h + this.h;
	}

	public double getArea() {
		return this.w * this.h;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(super.getColor().getARGB());
		gc.setLineWidth(2);
		gc.fillRect(super.getRef().getX(), super.getRef().getY(), this.w, this.h);
	}

	@Override
	public String toString() {
		return String.format("ref pt: " + super.getRef() + " area: " + getArea() + " perimeter: " + getPerimeter() +
				" width: " + getWidth() + " height: " + getHeight() + " color: " + super.getColor());
	}

	@Override
	public MyRectangle getBoundingRectangle(MyColor color) {
		return this;
	}

	@Override
	public double getMyArea() {
		return this.w * this.h;
	}
}