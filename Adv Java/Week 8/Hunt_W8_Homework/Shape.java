/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 8
 * Due: 10/22/2017
*/

import java.awt.Color;

public abstract class Shape {

	protected double x,y;
	protected Color c;
	protected boolean fill;
	public boolean SHAPE_DEFAULT_FILL = false;		// default fill is false
	public Color SHAPE_DEFAULT_COLOR = Color.gray;	// default fill is grey
	public boolean SHAPE_SET_FILL = true; 			// use with setFill
	public boolean SHAPE_SET_OUTLINE = false; 		// use with setFill
	
	protected Shape() {
		c 	 = SHAPE_DEFAULT_COLOR;
		fill = SHAPE_DEFAULT_FILL;
	}
	
	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public boolean getFill() {
		return fill;
	}

	public void setFill(boolean f){
		this.fill = f;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean getOutline(){
		return SHAPE_SET_OUTLINE;
	}
	
	public void setOutline(boolean outline){
		this.SHAPE_SET_OUTLINE = outline;
	}

	public double getArea(double length, double width) {
		double area = 0;
		if (getClass().getName() == "Rectangle") {
			area = length * width;
		}
		if(getClass().getName() == "Square") {
			area = width * width;
		}
		if(getClass().getName() == "Ellipse") {
			area = Math.PI * (length * width);
		}
		if(getClass().getName() == "Circle") {
			area = Math.PI * (length * width);
		}
		if(getClass().getName() == "Triangle") {
			area = (length * width) / 2;
		}
		
		return area;
	}

	public double getPerimeter(double width, double length, double side) {
		double p = 0;
		double two = 2;
		if (getClass().getName() == "Rectangle") {
			p = two * (length + width);
		}
		if(getClass().getName() == "Square") {
			p = 4 * width;
		}
		if(getClass().getName() == "Ellipse") {
			p = (two * Math.PI * width) * 2;
		}
		if(getClass().getName() == "Circle") {
			p = two * Math.PI * width;
		}
		if(getClass().getName() == "Triangle") {
			p = (two * side) + length;
		}
		return p;
	}

	abstract void drawShape();
}
