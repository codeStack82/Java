
public class Square extends Rectangle {
	
	public Square(double x, double y, double width) {
		super(x,y,width,width);
	}

	@Override
	public void drawShape() {
		System.out.println("\tDrawing " + getClass().getName() 
				+ " [ " + length + " x " + width + " ] " +
				" at " + x + " , " + y );
	}

}
