package application;

import javafx.scene.canvas.GraphicsContext;

public class MyLine extends MyShape {
	private double x2, y2;
	private MyColor color;

	public MyLine(MyPoint p, MyColor color, double x2, double y2) {
		super(p, color);
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
	}

	public double getLength() {
		return (Math.sqrt(Math.pow(super.getRef().getX() - x2, 2) + Math.pow(super.getRef().getY() - y2, 2)));
	}

	public double get_xAngle() {
		double rise = this.y2 - super.getRef().getY();
		double run = this.x2 - super.getRef().getX();
		return (double) rise == 0 ? 0
				: (double) run == 0 ? 0 : Math.toDegrees(Math.tan((double) (run) / (double) (rise)));
	}

	public double getSlope() {
		double rise = this.y2 - super.getRef().getY();
		double run = this.x2 - super.getRef().getX();
		return rise / run;
	}

	@Override
	public String toString() {
		return String.format("(x,y): ", super.getRef(), "(x2,y2): ",
				"(" + this.x2 + ", " + this.y2 + "), length: " + getLength() + " slope with angle : " + get_xAngle()
						+ " slope rise/run: " + getSlope() + " color: " + super.getColor());
	}

	@Override
	public void draw(GraphicsContext GC) {
		GC.setStroke(color.getARGB());
		GC.strokeLine(super.getRef().getX(), super.getRef().getY(), x2, y2);
	}

	@Override
	public MyRectangle getBoundingRectangle(MyColor color) {
		if (super.getRef().getY() > this.y2)
			return new MyRectangle(new MyPoint(super.getRef().getX(), this.y2), color,
					Math.abs(this.y2 - super.getRef().getY()),
					this.x2 - super.getRef().getX() == 0 ? 1 : this.x2 - super.getRef().getX());
		else
			return new MyRectangle(super.getRef(), color,
					this.y2 - super.getRef().getY() == 0 ? 1 : this.y2 - super.getRef().getY(),
					this.x2 - super.getRef().getX() == 0 ? 1 : this.x2 - super.getRef().getX());
	}

	@Override
	public double getMyArea() {
		return 0;
	}
}