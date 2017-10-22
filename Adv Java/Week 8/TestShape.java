/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 8
 * Due: 10/22/2017
*/

import java.awt.Color;

public class TestShape {
	
	public static Shape [] shapes;
	public static void main(String[] args) {
		
		shapes 	 = 	new Shape[10];
		shapes[0] = new Square (1, 1, 5);
		shapes[1] = new Square (2, 2, 5, Color.GREEN, true);
		shapes[2] = new Rectangle (3,3,5,5);
		shapes[3] = new Rectangle (4, 4, 5, 5, Color.BLUE, true);	
		shapes[4] = new Ellipse (5, 5, 5, 5);
		shapes[5] = new Ellipse (6, 6, 5, 5, Color.RED, true);
		shapes[6] = new Circle (7, 7, 5);
		shapes[7] = new Circle (8, 8, 5, Color.BLUE, true);
		shapes[8] = new Triangle (9, 9, 5, 5, 5);
		shapes[9] = new Triangle (10, 10, 5, 5, 5, Color.BLUE, true);

		for(int i = 0; i < shapes.length; i++) {
			shapes[i].drawShape();
		}
	
	}

}
