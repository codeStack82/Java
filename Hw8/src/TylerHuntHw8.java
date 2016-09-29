	/** PROGRAM ASSIGNMENT 8    TylerHuntHw8.java
*
* Author:         Tyler Hunt
* Class:          Java, CS2163-TX01F
* Due Date:       October 19, 2015
*
* Program Description:											
*/


import java.util.Scanner;  

public class TylerHuntHw8 {
	
	public static void main(String[] args) {
		// My unique student identifier print line
		System.out.println("Tyler Hunt, Java homework 8, Online, Fall 2015\n");
	
		// Create new scanner for input
		Scanner stdin = new Scanner(System.in);
		
		//Create 3 new House objects
		House houseNum1 = new House(295000, 3395);
		House houseNum2 = new House(189000, 1675);
		House houseNum3 = new House();
		
		//Get total Price for house #3 
		System.out.print("Enter the total Price for House #3: ");
		double houseTotalPrice = stdin.nextDouble();
		houseNum3.setTotalPrice(houseTotalPrice);
			
		//Get total square footage for house #3 
		System.out.print("Enter the total square footage of House #3: ");
		double houseSquareFootage = stdin.nextDouble();
		houseNum3.setTotalSquareFeet(houseSquareFootage);
	
		//Get user for tax percent
		System.out.print("Enter the tax percent: ");
		double taxPercent = stdin.nextDouble();
			
		//House 1 details	
		System.out.printf("\nHouse #1 Details" +"\r\tTotal house cost: $%8.2f"+ 
				"\r\tTotal square footage: %.0f sqft"+
				"\r\tPrice per square foot: $%4.2f per ft." + 
				"\r\tProtery tax: $%5.2f",
				houseNum1.getTotalPrice(),
				houseNum1.getTotalSqFeet(),
				houseNum1.calcPricePerSqf(),
				houseNum1.calcPropertyTax(taxPercent));
		
		//House 2 details	
		System.out.printf("\nHouse #2 Details" +"\r\tTotal house cost: $%8.2f"+ 
				"\r\tTotal square footage: %.0f sqft"+
				"\r\tPrice per square foot: $%4.2f per ft." + 
				"\r\tProtery tax: $%5.2f",
				houseNum2.getTotalPrice(),
				houseNum2.getTotalSqFeet(),
				houseNum2.calcPricePerSqf(),
				houseNum2.calcPropertyTax(taxPercent));
		
		//House 3 details	
		System.out.printf("\nHouse #3 Details" +"\r\tTotal house cost: $%8.2f"+ 
				"\r\tTotal square footage: %.0f sqft"+
				"\r\tPrice per square foot: $%4.2f per ft." + 
				"\r\tProtery tax: $%5.2f",
				houseNum3.getTotalPrice(),
				houseNum3.getTotalSqFeet(),
				houseNum3.calcPricePerSqf(),
				houseNum3.calcPropertyTax(taxPercent));
	
		
		//Close scanner object
		stdin.close();
		
	}//eo_main
	
}//eo_Hw8Class