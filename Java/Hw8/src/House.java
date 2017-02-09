	/** PROGRAM ASSIGNMENT 8    House.java
*
* Author:         Tyler Hunt
* Class:          Java, CS2163-TX01F
* Due Date:       October 19, 2015
*
* Program Description:
* public Class for House											
*/

public class House {
	
	// declare 2 private data members for House Class
	private double totalPrice = 0;
	private double totalSquareFeet = 0;
	
	//default constructor
	public House(){
		
	}
	
	//Constructor with parameters
	public House(double newPrice, double newTotalSqFeet){
		totalPrice = newPrice;
		totalSquareFeet = newTotalSqFeet;	
	}
	
	//Getter for total price of House
	public double getTotalPrice(){
		return totalPrice;
	}
	
	//Getter for house total square feet
	public double getTotalSqFeet(){
		return totalSquareFeet;
		
	}
	
	//Setter for total price
	public void setTotalPrice(double newTotalPrice){
		totalPrice = newTotalPrice;
	}
	
	//Setter for total square feet
	public void setTotalSquareFeet(double newTotalSqFeet){
		totalSquareFeet = newTotalSqFeet;
	}
	
	//Calculates the total square feet of House
	public double calcPricePerSqf(){
		return totalPrice / totalSquareFeet;
	}
	
	//Returns total property tax of House
	public double calcPropertyTax(double taxPercent){
		return totalPrice * taxPercent * 0.01;
	}
	
}
