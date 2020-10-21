package application;
// interface MyShapeInterface
interface MyShapeInterface {
	
	// return the bounding rectangle of the MyShape object
	public MyRectangle getBoundingRectangle(MyColor color);
	
	// return area of an object in the class hierarchy
	// set of all points on and within the boundary of the object
	public double getMyArea();
	
	// return intersecting area of two objects in the class hierarchy
	// if they overlap; null otherwise
	public MyRectangle overlapMyShapes(MyShape s1, MyShape s2);
	
	// check if rectangles overlap as well
	public MyRectangle overlapMyRectangles(MyRectangle r1, MyRectangle r2);
}