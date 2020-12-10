package application;

import javafx.scene.canvas.GraphicsContext;

public abstract class MyShape implements MyShapeInterface {
	private MyPoint p;
	private MyColor color;

	public MyShape(MyPoint p, MyColor color) {
		this.p = p;
		this.color = color;
	}

	public abstract void draw(GraphicsContext GC);

	public abstract String toString();

	public MyPoint getRef() {
		return p;
	}

	public void setRef(MyPoint p) {
		this.p = p;
	}

	public MyColor getColor() {
		return color;
	}

	public void setColor(MyColor color) {
		this.color = color;
	}

	public double getArea() {
		return 0;
	}

}