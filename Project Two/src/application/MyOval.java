package application;

import javafx.scene.canvas.GraphicsContext;

public class MyOval extends MyShape {
	private double h, w;
	private MyPoint c;

	public MyOval(MyPoint ref, MyColor color, double h, double w) {
		super(ref, color);
		this.h = h;
		this.w = w;
		setCenter(w, h);
	}

	@Override
	public MyRectangle getBoundingRectangle(MyColor c) {
		return new MyRectangle(super.getRef(), c, this.h, this.w);
	}
	
	public double getWidth() {
		return this.w;
	}

	public double getHeight() {
		return this.h;
	}

	public double getArea() {
		return Math.PI * this.h * this.w;
	}

	public double getPerimeter() {
		return (Math.PI + Math.PI) * (Math.sqrt((Math.pow(this.w, 2) + Math.pow(this.h, 2) / 2)));
	}

	public MyPoint getCenter() {
		return this.c;
	}

	public void setCenter(double w, double h) {
		this.c = new MyPoint(super.getRef().getX() + w / 2, super.getRef().getY() + (h / 2));
	}

	public void setAxes(double w, double h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(super.getColor().getARGB());
		gc.setStroke(super.getColor().getARGB());
		gc.setLineWidth(3);
		gc.fillOval(super.getRef().getX(), super.getRef().getY(), this.w, this.h);
	}

	@Override
	public String toString() {
		return String.format("ref pt" + super.getRef() + " area:" + getArea() + " perimeter:" + getPerimeter()
				+ " width: " + this.w + " height: " + this.h + " color: " + super.getColor());
	}

	@Override
	public double getMyArea() {
		return Math.PI * this.h * this.w;
	}
}
