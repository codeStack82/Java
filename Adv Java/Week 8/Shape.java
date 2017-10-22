import java.awt.Color;

public abstract class Shape {

	protected double x,y;
	protected Color c;
	protected boolean fill;
	public boolean SHAPE_DEFAULT_FILL = false;
	public Color SHAPE_DEFAULT_COLOR = Color.gray;
	public boolean SHAPE_SET_FILL = true; // use with setFill
	public boolean SHAPE_SET_OUTLINE = false; // use with setFill
	
	protected Shape() {
		c = SHAPE_DEFAULT_COLOR;
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
		this.f = fill;
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

	public double getArea(double length, double width){
		double area = 0;
		double two = 2;
		if (getClass().getName() == "Rectangle") {
			area = length * width;
		}
		if(getClass().getName() == "Square") {
			area = width * width;
		}
		if(getClass().getName() == "Ellipse") {
			area = Math.PI * length * width;
		}
		if(getClass().getName() == "Circle") {
			area = Math.PI * length * width;
		}
		if(getClass().getName() == "Triangle") {
			area = (length * width) / two;
		}
		
		return area;
	}

	public double getPerimeter(double length, double width, double side){
		double p = 0;
		double two = 2;
		if (getClass().getName() == "Rectangle") {
			p = two * (length + width);
		}
		if(getClass().getName() == "Square") {
			p = 4 * width;
		}
		if(getClass().getName() == "Ellipse") {
			p = two * Math.PI * Math.sqrt((Math.pow(width, two) + Math.pow(length, two)) / two);
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
