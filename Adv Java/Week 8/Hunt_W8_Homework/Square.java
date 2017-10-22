/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 8
 * Due: 10/22/2017
*/

import java.awt.Color;

public class Square extends Rectangle {
	
	public Square(double x, double y, double width) {
		super(x,y,width,width);
	}

	public Square(double x, double y, double width, Color color, boolean filled, boolean outlined) {
		super(x,y,width,width);
		super.setC(color);
		super.setFill(filled);
		super.setOutline(outlined);
	}

	@Override
	public void drawShape() {
		double area = getArea(length, width);
		double p = getPerimeter(length, width, 0);
		c = getC();
		fill = getFill();
		boolean lined = getOutline();
		System.out.println("Drawing a " + getClass().getName() + ":");
			System.out.println("\tSize:\t\t[ " + length + ", " + width + " ]");
			System.out.println("\tPosition:\tx = " + x + ", y = " + y );
			System.out.println("\tColor:\t\t" + c);
			System.out.println("\tFilled:\t\t" + fill);
			System.out.println("\tOutlined:\t" + lined);
			System.out.printf("\tArea:\t\t%.4f\n", area);
			System.out.printf("\tPerimeter:\t%.4f\n", p);
		System.out.println();
	}
}
