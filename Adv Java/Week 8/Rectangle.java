
public class Rectangle extends Shape {

	protected double length,width;
	
	public Rectangle(double x, double y, double length, double width) {
		super();
		this.x = x;
		this.y = y;
		this.length = length;
		this.width = width;
		
	}
	
	@Override
	public void drawShape() {
		System.out.println("\tDrawing " + getClass().getName() 
				+ " [ " + length + " x " + width + " ] " +
				" at " + x + " , " + y );
	}
}
