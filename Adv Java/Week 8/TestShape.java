
public class TestShape {
	
	public static Shape [] s;
	public static void main(String[] args) {
		
		Rectangle r = new Rectangle (10,10,10,10);
		r.drawShape();
		
		Square s1 = new Square (20,22,24);
		s1.drawShape();
		
		s = new Shape[3];
		s[0] =  new Rectangle (10,10,10,10);
		s[1] = 	new Square (20,22,24);
		s[2] = 	new Rectangle (55,66,77,88);
		
		for(int i = 0; i < s.length; i++) {
			s[i].drawShape();
		}
	
	}

}
