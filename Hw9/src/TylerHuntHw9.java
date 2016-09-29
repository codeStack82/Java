	/** PROGRAM ASSIGNMENT 9    TylerHuntHw9.java
*
* Author:         Tyler Hunt
* Class:          Java, CS2163-TX01F
* Due Date:       October 26, 2015
*
* Program Description:	
*  Java calculator with proper input validation 										
*/

public class TylerHuntHw9 {
	
	public static void main(String[] args) {
		// My unique student identifier print line
		System.out.println("Tyler Hunt, Java homework 9, Online, Fall 2015\n");
		
		//Check the number of args being passed from the console
		if(args.length != 3){
			System.out.println(
					"Usage:java TylerHuntHw9 operand1 operator operand2");
			System.exit(0);
		}
		
		// To hold the result of the arithmetic to be performed
	    int result = 0;
	
	    // Determine the operator to use and perform arithmetic as needed
	    // and Exit program if the operator is not valid
	    switch (args[1].charAt(0)) {
	    	case '+': result = Integer.parseInt(args[0]) +
	                           Integer.parseInt(args[2]);
	        	break;
	    	case '-': result = Integer.parseInt(args[0]) -
	                           Integer.parseInt(args[2]);
	        	break;
	    	case 'x': result = Integer.parseInt(args[0]) *
	                           Integer.parseInt(args[2]);
	        	break;
	    	case '/': result = Integer.parseInt(args[0]) /
	    		  			   Integer.parseInt(args[2]);
	        	break;
	    	case '%': result = Integer.parseInt(args[0]) %
	              			   Integer.parseInt(args[2]);
	    		break;
	    	default: System.out.println(
	    			"Supported operators are +, -, x, /, and %");
	      	System.exit(0);
	    }

	    // Display results of the arithmetic to the console
	    System.out.println(args[0] + ' ' + args[1] + ' ' 
	      + args[2] + " = " + result);	 
	    
	}//eo_main
	
}//eo_Hw9Class