	/** PROGRAM ASSIGNMENT 5     TylerHuntHw5.java
	 *
	 * Author:         Tyler Hunt
	 * Class:          Java, CS2163-TX01F
	 * Due Date:       September 20, 2015
	 *
	 * Program Description:											
	 * Program gets the total cost and square feet from
	 * the user. Then it calls the calcPricePerSqFt method
	 * to calculate the price per square feet. 
	*/


import java.util.Scanner;

public class TylerHuntHw5 {
	public static void main(String[] args) {
		// My unique student identifier print line
		System.out.println("Tyler Hunt, Java homework 5, Online, Fall 2015\n");
		
		// Create new scanner for user input
		Scanner stdin = new Scanner(System.in);
	
		// Ask user to input total house cost
		System.out.print("Enter total house cost: ");
		double houseCost = stdin.nextDouble();  
		
		// Ask user to input total square feet of house
		System.out.print("Enter total square feet: ");
		double squareFeet = stdin.nextDouble();
		
		// Variable to hold the return value from calcPricePerSqFt Method
		double pricePerSquareFt = calcPricePerSqFt(houseCost, squareFeet);
		
		// Print out the final details
		System.out.printf("The price per square foot is: $%.2f", 
				pricePerSquareFt);
		
		// Clean up - close the Scanner stdin
		stdin.close();
	}
	
	// Method calculate the price per square foot, returns ppf as a double
	public static double calcPricePerSqFt(double cost, double sqFt){
	
		//Calculate the cost of the house in price per square foot
		double result = cost / sqFt;
	
		return result;
	}
}