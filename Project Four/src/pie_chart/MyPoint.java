package pie_chart;

public class MyPoint {
	private double x, y;

	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}