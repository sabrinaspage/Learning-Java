package assignment_1;

import javafx.scene.paint.Color;

public class MyShape {
    int x, y;
    Color color;

    MyShape(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y;}

    public int getX() { return x; }
    public int getY() { return y; }
}
