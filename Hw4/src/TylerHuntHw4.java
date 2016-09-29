	/** PROGRAM ASSIGNMENT 4     TylerHuntHw4.java
	 *
	 * Author:         Tyler Hunt
	 * Class:          Java, CS2163-TX01F
	 * Due Date:       September 14, 2015
	 *
	 * Program Description:											
	 * Build a grocery list that accumulates the 
	 * total cost of each item added using the 
	 * JOptionPane windows
	*/

import javax.swing.JOptionPane;

public class TylerHuntHw4 {
	public static void main(String[] args) {
		// My unique student identifier print line
		System.out.println("Tyler Hunt, Java homework 4, Online, Fall 2015\n");
		
		double totalCost = 0;		// holds the accumulated total cost
		double totalItem = 0;		// holds the total cost for an item
		int option;					// holds loop sentinel value
		int counter = 0;			// holds item counter variable
		
		do{
			// Increment the item counter
			counter += 1;
			
			// Get unit price from user ///////////////////////////////////////
			String input_UnitPrice = JOptionPane.showInputDialog("Please "
					+ "enter the unit price for a grocery item: ");
			// parse string value from jOptionPane into an double
			double unitPrice = Double.parseDouble(input_UnitPrice);
				// Print to console for error checking 
				System.out.println("Price: $" + input_UnitPrice);
			
			// Get number of units from user //////////////////////////////////
			String input_NumberUnits = JOptionPane.showInputDialog("Please "
					+ "enter the number of units: ");
			// parse string value from jOptionPane into an integer
			int numberUnits = Integer.parseInt(input_NumberUnits);
				// Print to console for error checking 
				System.out.println("Units: " + input_NumberUnits);
			
			// Calculate total cost for item //////////////////////////////////
			totalItem = unitPrice * numberUnits;
				// Print to console for error checking 
				System.out.println( "Total item cost: $" + totalItem);
				
			// Calculate the accumulated total cost ///////////////////////////
			totalCost += totalItem;
				// Print to console for error checking 
				System.out.println("Item " + counter + ") " + "Total"
						+ " item cost: $" + totalCost);
				
			// Ask user if they want to continue? /////////////////////////////
			option = JOptionPane.showConfirmDialog(null, "Would you like"
					+ " to Continue?");
			
		// Loop if option selected == Yes /////////////////////////////////////
		}while (option == JOptionPane.YES_OPTION);
		
	    // Display the total results to the user //////////////////////////////
		JOptionPane.showMessageDialog(null, "The total cart cost "
				+ "is: $" + totalCost);
	    	// Print to the console for error checking
			System.out.println("The total cost is: $" + totalCost);
	
	}
}
