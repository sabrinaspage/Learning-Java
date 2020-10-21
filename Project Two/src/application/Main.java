package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	public static int FORMAT_CONST = 2;

	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		try {
			stage.setTitle("CSC 22100 Assignment 2");
			Pane pane = new Pane();
			Canvas canvas = addCanvas(600, 400);
			pane.getChildren().add(canvas);
			Scene scene = new Scene(pane, 600, 400, MyColor.WHITE.getARGB());
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public Canvas addCanvas(int cWidth, int cHeight) {
		Canvas canvas = new Canvas(cWidth, cHeight);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		MyLine m1 = new MyLine(new MyPoint(0, 0), MyColor.BLACK, 600, 400);
		MyLine m2 = new MyLine(new MyPoint(0, 0), MyColor.BLACK, 600, 0);
		MyLine m3 = new MyLine(new MyPoint(0, 0), MyColor.BLACK, 0, 500);
		MyLine m4 = new MyLine(new MyPoint(0, 400), MyColor.BLACK, 600, 400);
		MyLine m5 = new MyLine(new MyPoint(600, 0), MyColor.BLACK, 600, 400);

		MyShape o = new MyOval(new MyPoint(100, 100), MyColor.CYAN, 200, 400);
		MyRectangle r1 = o.getBoundingRectangle(MyColor.BLUE);

		MyShape o2 = new MyOval(new MyPoint(155, 130), MyColor.LIME, 140, 290);
		MyRectangle r2 = o2.getBoundingRectangle(MyColor.GREEN);

		MyShape o3 = new MyOval(new MyPoint(200, 150), MyColor.YELLOW, 100, 200);
		MyRectangle r3 = o3.getBoundingRectangle(MyColor.BLUE);

		// for drawing pattern of circles and ovals

		r1.draw(gc);
		o.draw(gc);
		r2.draw(gc);
		o2.draw(gc);
		r3.draw(gc);
		o3.draw(gc);

		// for drawing the outer rectangle
		// and diagonal line

		m1.draw(gc);
		m2.draw(gc);
		m3.draw(gc);
		m4.draw(gc);
		m5.draw(gc);
		return canvas;
	}
}
