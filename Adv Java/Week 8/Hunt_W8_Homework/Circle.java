/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 8
 * Due: 10/22/2017
*/

import java.awt.Color;

public class Circle extends Ellipse {
	protected double r;

	public Circle(double x, double y, double r) {
		super(x,y,r,r);
        this.r =r ;
	}

	public Circle(double x, double y, double r, Color color, boolean filled, boolean outlined) {
		super(x,y,r,r);
        this.r = r;
		super.setC(color);
		super.setFill(filled);
        super.setOutline(outlined);
	}

	@Override
	public void drawShape() {
		double area = getArea(r, r);
		double p = getPerimeter(r, 1, 1);
		c = getC();
		fill = getFill();
        boolean lined = getOutline();
		System.out.println("Drawing a " + getClass().getName() + ":");
			System.out.println("\tSize:\t\t[ " + r + " ]");
			System.out.println("\tPosition:\tx = " + x + ", y = " + y );
			System.out.println("\tColor:\t\t" + c);
			System.out.println("\tFilled:\t\t" + fill);
            System.out.println("\tOutlined:\t" + lined);
			System.out.printf("\tArea:\t\t%.4f\n", area);
			System.out.printf("\tPerimeter:\t%.4f\n",p);
		System.out.println();
	}
}
