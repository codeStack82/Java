/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 8
 * Due: 10/22/2017
*/

import java.awt.Color;

public class Ellipse extends Shape{

    protected double radius1;
    protected double radius2;
    protected Color color;
	protected boolean filled;

    public Ellipse(double x, double y, double r1, double r2){
        super();
        this.x = x;
        this.y = y;
        this.radius1 = r1;
        this.radius2 = r2;
    } 

    public Ellipse(double x, double y, double r1, double r2, Color color, boolean filled, boolean outlined) {
		super();
		this.x = x;
		this.y = y;
		this.radius1 = r1;
		this.radius2 = r2;
		super.setC(color);
		super.setFill(filled);
        super.setOutline(outlined);
	}

    @Override
    public void drawShape() {
        double area = getArea(radius1, radius2);
        double p = getPerimeter(radius1, radius2, 0);
        c = getC();
        fill = getFill();
        boolean lined = getOutline();
        System.out.println("Drawing a " + getClass().getName() + ":");
            System.out.println("\tSize:\t\t[ " + radius1 + ", " + radius2 + " ]");
            System.out.println("\tPosition:\tx = " + x + ", y = " + y );
            System.out.println("\tColor:\t\t" + c);
            System.out.println("\tFilled:\t\t" + fill);
            System.out.println("\tOutlined:\t" + lined);
            System.out.printf("\tArea:\t\t%.4f\n",area);
            System.out.printf("\tPerimeter:\t%.4f\n", p);
        System.out.println();
    }
}
