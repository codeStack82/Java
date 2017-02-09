	/** PROGRAM ASSIGNMENT 10    TylerHuntHw10.java
*
* Author:         Tyler Hunt
* Class:          Java, CS2163-TX01F
* Due Date:       November 2, 2015
*
* Program Description:	
*  	Class implements/calculates/utilizes objects from the 
*  RentalCar class								
*/
import java.util.*;

public class TylerHuntHw10{
	
	public static void main(String[] args) {
		// My unique student identifier print line
		System.out.println("Tyler Hunt, Java homework 10, Online, Fall 2015\n");
		
		//Create a new scanner
		Scanner input = new Scanner(System.in);
		
		// Create rental car objects
		RentalCar car1 = new RentalCar("suv", 500.0);
		RentalCar car2 = new RentalCar("sedan", 1200.0);
		RentalCar car3 = new RentalCar();
		
		//Get user input for car #3 
		System.out.printf("Enter the car type for car #3: ");
		String getCar3Type = input.nextLine();
		car3.setCarType(getCar3Type);
		
		//Get user input for car #3 
		System.out.printf("Enter the mileage for car #3: ");
		double getCarMiles = input.nextDouble();
		car3.setMileage(getCarMiles);
		
		//Get mile threshold from user
		System.out.printf("Enter the miles threshold for car #3: ");
		double milesThreshold = input.nextDouble();
		
		//Calculate each cars details
		double car1_RentalCost = car1.calcRentalFee();
		boolean car1_OilChange = car1.isOilChangeNeeded(milesThreshold);
		
		double car2_RentalCost = car2.calcRentalFee();
		boolean car2_OilChange = car2.isOilChangeNeeded(milesThreshold);
		
		double car3_RentalCost = car3.calcRentalFee();
		boolean car3_OilChange = car3.isOilChangeNeeded(milesThreshold);
		
		//Print each cars details to the console
		System.out.printf("\nRental Car #1\n"
				+ "\tCar type: %s\n "
				+ "\tMiles travled: %.1f\n"
				+ "\tRental fee: $%.2f\n"
				+ "\tOil change needed: %b\n"
				,car1.getCarType(), car1.getMileage()
				,car1_RentalCost, car1_OilChange);
		
		System.out.printf("\nRental Car #2\n"
				+ "\tCar type: %s\n "
				+ "\tMiles travled: %.1f\n"
				+ "\tRental fee: $%.2f\n"
				+ "\tOil change needed: %b\n"
				,car2.getCarType(), car2.getMileage()
				,car2_RentalCost, car2_OilChange);
		
		System.out.printf("\nRental Car #3\n"
				+ "\tCar type: %s\n "
				+ "\tMiles travled: %.1f\n"
				+ "\tRental fee: $%.2f\n"
				+ "\tOil change needed: %b\n"
				,getCar3Type, car3.getMileage()
				,car3_RentalCost, car3_OilChange);
		
		System.out.printf("\nThe Rental Fee = %2.2f cents per mile\n"
				+ "Total number of cars rented =  %.2s"
				, RentalCar.COST_PER_MILE ,RentalCar.getNumRented());
		
		//close scanner object 
		input.close();
		
	}//eo_main
	
}//eo_Hw9Class