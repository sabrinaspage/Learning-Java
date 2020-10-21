package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;

class GlobalVals {
	final static int canvasY = 500;
	final static int canvasX = 800;
}

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		stage.setTitle("CSC22100 Assignment 01");

		StackPane pane = new StackPane();
		Scene scene = new Scene(pane, GlobalVals.canvasX, GlobalVals.canvasY);
		stage.setScene(scene);

		Canvas canvas = new Canvas(GlobalVals.canvasX, GlobalVals.canvasY);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		MyShape background = new MyShape(800, 500, MyColor.WHITE);
		background.draw(gc);

		// shapes of varying sizes
		
		MyCircle circle1 = new MyCircle(GlobalVals.canvasX/2 -250, GlobalVals.canvasY/2 -250, 250, MyColor.WHITE);
		circle1.draw(gc);
		MyPolygon polygon1 = new MyPolygon(GlobalVals.canvasX/2, GlobalVals.canvasY/2, 5, 250, MyColor.RED);
		polygon1.draw(gc);
		
		MyCircle circle2 = new MyCircle(GlobalVals.canvasX/2 - 175, GlobalVals.canvasY/2 - 175, 175, MyColor.RED);
		circle2.draw(gc);
		MyPolygon polygon2 = new MyPolygon(GlobalVals.canvasX/2, GlobalVals.canvasY/2, 5, 175, MyColor.BLUE);
		polygon2.draw(gc);
		
		MyCircle circle3 = new MyCircle(GlobalVals.canvasX/2 - 100, GlobalVals.canvasY/2 - 100, 100, MyColor.RED);
		circle3.draw(gc);
		MyPolygon polygon3 = new MyPolygon(GlobalVals.canvasX/2, GlobalVals.canvasY/2, 5, 100, MyColor.RED);
		polygon3.draw(gc);
		
		// defines the borders of the canvas
		MyLine bottomBorder = new MyLine(0, GlobalVals.canvasY, GlobalVals.canvasX, GlobalVals.canvasY,
				MyColor.BLACK);
		bottomBorder.draw(gc);
		MyLine topBorder = new MyLine(0, 0, GlobalVals.canvasX, 0, MyColor.BLACK);
		topBorder.draw(gc);
		MyLine leftBorder = new MyLine(0, 0, 0, GlobalVals.canvasY, MyColor.BLACK);
		leftBorder.draw(gc);
		MyLine rightBorder = new MyLine(GlobalVals.canvasX, 0, GlobalVals.canvasX, GlobalVals.canvasY, MyColor.BLACK);
		rightBorder.draw(gc);

		// defines the diagonals on the canvas

		MyLine leftDiagonal = new MyLine(0, 0, GlobalVals.canvasX, GlobalVals.canvasY, MyColor.BLACK);
		leftDiagonal.draw(gc);
		MyLine rightDiagonal = new MyLine(0, GlobalVals.canvasY, GlobalVals.canvasX, 0, MyColor.BLACK);
		rightDiagonal.draw(gc);

		pane.getChildren().add(canvas);

		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}