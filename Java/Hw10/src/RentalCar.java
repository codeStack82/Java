	/** PROGRAM ASSIGNMENT 10    TylerHuntHw10.java
*
* Author:         Tyler Hunt
* Class:          Java, CS2163-TX01F
* Due Date:       November 2, 2015
*
* Program Description:	
*   Rental Car Class										
*/

public class RentalCar {
	// My unique student identifier print line
	// System.out.println("Tyler Hunt, Java homework 10, Online, Fall 2015\n");
	
	/**Data Fields*/
	private double mileage;
	private String carType= " ";
	private static int numRented = 0;
	public static final double COST_PER_MILE = 0.25;
	
	/**Constructors*/
	public RentalCar(){	
		numRented++;
	};
	
	public RentalCar(String carType, double mileage){
		this.carType = carType;
		this.mileage = mileage;
		numRented++;
	};
	
	/**Getters*/
	public double getMileage(){
		return mileage;
	}

	public String getCarType() {
		return carType;
	}
	
	public static int getNumRented(){
		return numRented;
	}

	/**Setters*/
	public void setMileage(double mileage){
		this.mileage = mileage;
	}
	
	public void setCarType(String carType) {
		this.carType = carType;
	}
	
	/**Executers*/
	public double calcRentalFee(){
		return COST_PER_MILE * mileage;
	}
	
	public boolean isOilChangeNeeded(double milesThreshold){
		if (mileage <= milesThreshold)
			return false;
		else 
			return true;
	}
}
