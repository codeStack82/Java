/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 8
 * Due: 10/22/2017
*/

public class Ellipse extends Shape{

    protected double radius1;
    protected double radius2;
    protected String color;
	protected boolean filled;

    Ellipse(double x, double y, double r1, double r2){
        super();
        this.x = x;
        this.y = y;
        this.radius1 = r1;
        this.radius2 = r2;
    } 

	@Override
	public void drawShape() {
        System.out.println();
    }
}
