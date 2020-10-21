package application;

import javafx.scene.paint.Color;

enum MyColor {
	// static classes which define colors
	BLUE(0, 255, 255, 1), RED(255, 0, 0, 1), BLACK(0, 0, 0, 1), WHITE(255, 255, 255, 1);
	
	// integers which belong to RGBA colors
	
	private int r, g, b, opacity;
	
	// constructor which defines RGB and opacity values

	MyColor(int r, int g, int b, int opacity) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.opacity = opacity;
	}
	
	// return the color

	public Color getARGB() {
		return Color.rgb(r, g, b, opacity);
	}
};