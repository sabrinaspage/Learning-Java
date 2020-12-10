package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

interface CONSTANTS {
	MyPoint BASIS = new MyPoint(10,100);
	MyOval OVAL_BASIS = new MyOval(CONSTANTS.BASIS, MyColor.TRANSPARENT, 600, 600);
}


public class Main extends Application {
	/**
	 *
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Canvas canvas = new Canvas(500, 440);
			GraphicsContext gc = canvas.getGraphicsContext2D();

			Pane root = new Pane();
			root.getChildren().add(canvas);
			
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Canvas based on Emma");
			primaryStage.show();
						
			MyPieChart chart = new MyPieChart(CONSTANTS.BASIS, MyColor.LIGHT_GRAY, 5, new HistogramAlphaBet());
			System.out.println(chart.toString() + "\n");

			chart.draw(gc);
			
			System.out.println(chart.toString() + "\n");

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
