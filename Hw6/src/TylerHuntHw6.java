	/** PROGRAM ASSIGNMENT 6     TylerHuntHw6.java
	 *
	 * Author:         Tyler Hunt
	 * Class:          Java, CS2163-TX01F
	 * Due Date:       October 5, 2015
	 *
	 * Program Description:											
	 *	Program utilizes the math.random to fill an array,
	 *  the array is printed from a printArray method,
	 *  the array is then sorted via a selection sort method,
	 *  then it is printed again via the printArray method in 
	 *  the main mathod
	*/

public class TylerHuntHw6 {
	public static void main(String[] args) {
		// My unique student identifier print line
		System.out.println("Tyler Hunt, Java homework 6, Online, Fall 2015\n");

		// Declare array of 10 elements
		double[] arrNum1 = new double[10];
		
		// Populate array with the random values using math.random
		for(int i = 0; i < arrNum1.length; i++){
			arrNum1[i] = (double)Math.random() * 100;
		}
		
		//call printArray method to print original array
		printArray(arrNum1);
		
		//call the sort method to sort the array  in descending order
		sort(arrNum1);
		
		//call the print array again to print the sorted array
		printArray(arrNum1);
		
	}//EoMain
	  
	// Static method to print the contents of the array that is passed to it
	public static void printArray(double[] array){
		for(double arr: array){
			System.out.printf("%.2f ",arr);
		}
		System.out.print("\n");
	}//EoMethod
	
	//Static Selection Sort method 
	public static void sort(double[] array){
		
		//Implement Selection Sort Method to sort the array
		for(int i = 0; i < array.length - 1; i++){
			//find maximum element value in arraySort
			double currentMax = array[i];
			int currentMaxIndex = i;
			
			for(int j = i + 1; j < array.length; j++){
				if(currentMax < array[j]){
					currentMax = array[j];
					currentMaxIndex = j;
				}
			}
			//Swap arraySort[i] with arraySort[currentMax] if needed
			if(currentMaxIndex != i){
				array[currentMaxIndex] = array[i];
				array[i] = currentMax;
				}
			}
	}//EoMethod
	
}//EoClassMethod
