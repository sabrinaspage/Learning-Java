package application;
import pie_chart.MyPoint;
import pie_chart.MyOval;
import pie_chart.MyColor;

public class CONSTANTS {
	private CONSTANTS() {}
	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://127.0.0.1:3306/assignmentfour_sql";
	public static final String username = "root";
	public static final String password = "Ahambaga13&";
	
	public static final MyPoint BASIS = new MyPoint(100,100);
	public static final MyOval OVAL_BASIS = new MyOval(BASIS, MyColor.TRANSPARENT, 600, 600);

}