/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 8
 * Due: 10/22/2017
*/

import java.awt.Color;

public class Triangle extends Shape {
    protected double height, base, side;
	
	public Triangle(double x, double y, double height, double base, double side) {
		super();
        this.x = x;
        this.y = y;
        this.height = height;
        this.base = base;
        this.side = side;
	}

	public Triangle(double x, double y, double height, double base, double side, Color color, boolean filled, boolean outlined) {
		super();
        this.x = x;
        this.y = y;
        this.height = height;
        this.base = base;
        this.side = side;
        super.setC(color);
        super.setFill(filled);
        super.setOutline(outlined);
	}

	@Override
	public void drawShape() {
		double area = getArea(height, base);
		double p = getPerimeter(height, base, side);
		c = getC();
		fill = getFill();
        boolean lined = getOutline();
		System.out.println("Drawing a " + getClass().getName() + ":");
			System.out.println("\tSize:\t\t[ " + height + ", " + base + ", " + side +" ]");
			System.out.println("\tPosition:\tx = " + x + ", y = " + y );
			System.out.println("\tColor:\t\t" + c.toString());
			System.out.println("\tFilled:\t\t" + fill);
            System.out.println("\tOutline:\t" + lined);
			System.out.printf("\tArea:\t\t%.4f\n", area);
			System.out.printf("\tPerimeter:\t%.4f\n", p);
		System.out.println();
	}
}
