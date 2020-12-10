package pie_chart;

import javafx.scene.canvas.GraphicsContext;

public class MyOval extends MyShape {
	private double h, w;
	private MyPoint center;

	public MyOval(MyPoint ref, MyColor color, double h, double w) {
		super(ref, color);
		this.h = h;
		this.w = w;
		setCenter(w, h);
	}
	
	// use height and width to get reference 
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
	
	// perimeter of oval
	public double getPerimeter() {
		return (Math.PI + Math.PI) * (Math.sqrt((Math.pow(this.w, 2) + Math.pow(this.h, 2) / 2)));
	}
	
	// center of oval

	public MyPoint getCenter() {
		return this.center;
	}

	// set oval to the center
	public void setCenter(double w, double h) {
		this.center = new MyPoint(super.getRef().getX() + this.w / 2, super.getRef().getY() + (this.h / 2));
	}
	
	// axis of oval

	public void setAxes(double w, double h) {
		this.w = w;
		this.h = h;
	}
	
	// radius of oval if circle
	
	public double getRadius() {
		if (this.w == this.h) {
			return Math.sqrt(getArea()*Math.PI);
		}
		return 0;
	}
	
	// draw oval

	@Override
	public void draw(GraphicsContext gc) {
		gc.setFill(super.getColor().getARGB());
		gc.setStroke(super.getColor().getARGB());
		gc.fillOval(super.getRef().getX(), super.getRef().getY(), this.w, this.h);
	}

	// oval info
	@Override
	public String toString() {
		return String.format("ref pt" + super.getRef() + " area:" + getArea() + " perimeter:" + getPerimeter()
				+ " width: " + this.w + " height: " + this.h + " color: " + super.getColor());
	}

	// oval area
	@Override
	public double getMyArea() {
		return Math.PI * this.h * this.w;
	}
}