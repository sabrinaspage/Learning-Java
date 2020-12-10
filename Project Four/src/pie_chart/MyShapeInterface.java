package pie_chart;

import pie_chart.MyColor;
import pie_chart.MyRectangle;

@SuppressWarnings("unused")
// interface MyShapeInterface
interface MyShapeInterface {
	
	// return the bounding rectangle of the MyShape object
	public MyRectangle getBoundingRectangle(MyColor color);
	
	// return area of an object in the class hierarchy
	// set of all points on and within the boundary of the object
	public double getMyArea();
	
}