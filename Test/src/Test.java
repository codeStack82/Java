import java.util.Date;

public class Test {

	public static void main(String[] args){
		Date date = new Date(1234567);
		m1(date);
		System.out.print(date.getTime());

	}
	
	public static void m1(Date date){ 
		date = null;
	}

	
}//eo_Test class

