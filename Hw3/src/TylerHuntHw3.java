/** PROGRAM ASSIGNMENT 3     TylerHuntHw3.java
 *
 * Author:         Tyler Hunt
 * Class:          Java, CS2163-TX01F
 * Due Date:       September 7, 2015
 *
 * Program Description:											
 *
*/
import java.util.Scanner;

public class TylerHuntHw3 {
	public static void main(String[] args) {
		// My unique student identifier print line
		System.out.println("Tyler Hunt, Java homework 3, Online, Fall 2015\n");
		
		// Declare and Create a Scanner for user input
		Scanner stdin = new Scanner(System.in);
		
		//Prompt the user for the day of the week
		System.out.println("Enter a day of the week as a number 0 - 6: \n" +
							"(Ex: Sunday=0, Wednesday=3, Saturday=6)"); 
		
		//Get user input for the number of the day of the week
		int dayNumber = stdin.nextInt();
		
		//Validate the users input before passing the dayNumber to the switch 
		if (dayNumber >= 0 && dayNumber <=6){
		
			//switch statement to get operating hours
			switch(dayNumber){
				case 0 : System.out.println("Sunday: Closed");
					break;
				case 1 : System.out.println("Monday: "+
											"7:30 a.m. to 10:45 p.m.");
					break;
				case 2 : System.out.println("Tuesday: "+  
											"7:30 a.m. to 10:45 p.m.");
					break;
				case 3 : System.out.println("Wednesday: "+
											"7:30 a.m. to 10:45 p.m.");
					break;
				case 4 : System.out.println("Thursday: "+
											"7:30 a.m. to 10:45 p.m.");
					break;
				case 5 : System.out.println("Friday: "+
											"7:30 a.m. to 8:45 p.m.");
					break;
				case 6: System.out.println("Saturday: "+
											"8:00 a.m. to   4:45 p.m.");
					break;
				default : System.out.println("Error: Invalid Entry.......\n"+
							"A valid entry is between 0 and 6 "+ 
							"representing Sunday to Saturday respectively");
					break;
			}
		}
		//if user input is not valid.....
		else {
			System.out.println("Error: Invalid Entry.......\n"+
					"A valid number is between 0 and 6 "+ 
					"representing Sunday to Saturday respectively");
		}

		//Close scanner 
		stdin.close();
	}
}
