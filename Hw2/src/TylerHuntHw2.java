/** PROGRAM ASSIGNMENT 2     TylerHuntHw2.java
 *
 * Author:         Tyler Hunt
 * Class:          Java, CS2163-TX01F
 * Due Date:       August 30, 2015
 *
 * Program Description:/											
 *  This is the second assignment for
 *	this Java CS2164 class. It accepts hours worked,
 *	Hourly pay rate, and tax rate. It then calculates
 *	the pre and post taxed wages as well as the actual 
 *	tax amount
 *
*/
import java.util.Scanner;

public class TylerHuntHw2 {
	public static void main(String[] args) {
		// My unique student identifier print line
		System.out.println("Tyler Hunt, Java homework 2, Online, Fall 2015");
		
		// Declare and Create a Scanner for user input
		Scanner input = new Scanner(System.in);
		
		//Get the hourly pay rate
		System.out.print("Enter the hourly pay rate: ");
		double hourlyPayRate = input.nextDouble();
		
		//Get hours worked from user
		System.out.print("Enter total hours worked: ");
		int hoursWorked = input.nextInt();
		
		//Get user input
		System.out.print("Enter the tax rate: ");
		double taxRate = input.nextDouble();
		
		//Calculate total income
		double totalGrossIncome = hourlyPayRate * hoursWorked;
	
		//Calculate total income after tax
		double totalNetIncome = totalGrossIncome - 
				(totalGrossIncome * taxRate);
		
		//Display total gross income message
		System.out.println("The total income before tax is = $" 
				+ totalGrossIncome);
		
		//Display total net income message
		System.out.println("The total income after taxes is = $" 
				+ totalNetIncome);
		
		//Display total taxes message
		System.out.println("The total amount taxes is = $" 
				+ (totalGrossIncome * taxRate));
		
		//Close scanner 
		input.close();
		
	}
}
