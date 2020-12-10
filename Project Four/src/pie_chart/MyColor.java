package pie_chart;

import javafx.scene.paint.Color;

public enum MyColor {
	// static classes which define colors
	RED(255, 0, 0, 255), BLUE(0, 0, 255, 255), LIME(0, 255, 0, 255), CYAN(0, 255, 255, 255), GREEN(0, 128, 0, 255),
	YELLOW(255, 255, 0, 255), BLACK(0, 0, 0, 255), LIGHT_GRAY(211, 211, 211, 255), TRANSPARENT(0, 0, 0, 255),
	PURPLE(128, 0, 128, 255), MAROON(128, 0, 0, 255), PINK(255, 192, 203, 255), LIGHT_PINK(255, 182, 193, 255),
	HOT_PINK(255, 105, 180, 255), DEEP_PINK(255, 20, 147, 255), OLIVE_DRAB(107, 142, 35, 255), OLIVE(128, 128, 0, 255),
	DARK_OLIVE_GREEN(85, 107, 47, 255), MEDIUM_AQUAMARINE(102, 205, 170, 255), TEAL(0, 128, 128, 255),
	DARK_CYAN(0, 139, 139, 255), LIGHT_SEA_GREEN(32, 178, 170, 255), STEEL_BLUE(70,130,180,255), LIGHT_STEEL_BLUE(176,196,222,255), POWDER_BLUE(173,216,230,255);

	private int r;
	private int g;
	private int b;
	private int a;
	private int argb;

	MyColor(int r, int g, int b, int a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		setARGB(a, r, g, b);
	}

	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}

	public int getA() {
		return a;
	}

	public int getargb() {
		return argb;
	}

	public void setR(int r) {
		if (r >= 0 && r <= 255)
			this.r = r;
	}

	public void setG(int g) {
		if (g >= 0 && g <= 255)
			this.g = g;
	}

	public void setB(int b) {
		if (b >= 0 && b <= 255)
			this.b = b;
	}

	public void setA(int a) {
		if (a >= 0 && a <= 255)
			this.a = a;
	}

	public void setARGB(int a, int r, int g, int b) {
		this.argb = (a << 24) & 0xFF000000 | (r << 16) & 0x00FF0000 | (g << 8) & 0x0000FF00 | b;
	}

	public double convertRGBA(int val) {
		return (double) val / 255;
	}

	@Override
	public String toString() {
		return "(r: " + this.getR() + ", g:" + this.getG() + ", b:" + this.getB() + ", a: " + this.getA() + ")";
	}

	public Color getARGB() {
		return new Color(convertRGBA(getR()), convertRGBA(getG()), convertRGBA(getB()), convertRGBA(getA()));
	}
};