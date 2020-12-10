package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import pie_chart.MyColor;
import pie_chart.MyPieChart;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Canvas canvas = new Canvas(800, 700);
			GraphicsContext gc = canvas.getGraphicsContext2D();
	        			
			Pane root = new Pane();
			root.getChildren().add(canvas);
			
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Canvas based on Classes Table");
			primaryStage.show();
			
			JavaDB.connect();
			MyPieChart chart = new MyPieChart(CONSTANTS.BASIS, MyColor.TRANSPARENT, 6, new HistogramGrades());
			chart.draw(gc);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
