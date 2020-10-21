package application;

import javafx.scene.paint.Color;

enum MyColor {
	// static classes which define colors
	RED(255, 0, 0, 255), BLUE(0, 0, 255, 255), LIME(0, 255, 0, 255), CYAN(0, 255, 255, 255), GREEN(0, 128, 0, 255),
	YELLOW(255, 255, 0, 255), WHITE(255, 255, 255, 255), BLACK(0, 0, 0, 255);
	private int r;
    private int g;
    private int b;
    private int a;
    private int argb;

    MyColor(int r, int g, int b, int a){
        setR(r);
        setG(g);
        setB(b);
        setA(a);
        setArgb(r, g, b, a);
    }

    public void setR(int r) { if(r >= 0 && r <= 255) this.r = r; }
    public void setG(int g) { if(g >= 0 && g <= 255) this.g = g; }
    public void setB(int b) { if(b >= 0 && b <= 255) this.b = b; }
    public void setA(int a) { if(a >= 0 && a <= 255) this.a = a; }
    public void setArgb(int r, int g, int b, int a) {
        this.argb = (a << 24) & 0xFF000000 |
                (r << 16) & 0x00FF0000 |
                (g << 8) & 0x0000FF00 |
                b;
    }

    public int getR() { return r; }
    public int getG() { return g; }
    public int getB() { return b; }
    public int getA() { return a; }
    public int getArgb() { return argb; }

    @Override
    public String toString() {
        return "(r: " + this.getR() + ", g:" + this.getG() + ",b:" + this.getB() + ")";
    }

    public Color getARGB(){
        return new Color((double) getR()/255, (double) getG()/255, (double) getB()/255, (double) getA()/255);
    }
};