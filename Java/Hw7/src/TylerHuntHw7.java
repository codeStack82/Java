	/** PROGRAM ASSIGNMENT 7    TylerHuntHw7.java
*
* Author:         Tyler Hunt
* Class:          Java, CS2163-TX01F
* Due Date:       October 12, 2015
*
* Program Description:											
* use a multi-demisional array to store
* students credits. Traverse, sum and then print the 
* array as requried.
*/


import java.util.Scanner;  

public class TylerHuntHw7 {
public static void main(String[] args) {
	// My unique student identifier print line
	System.out.println("Tyler Hunt, Java homework 7, Online, Fall 2015\n");

	// Create new scanner for input
	Scanner stdin = new Scanner(System.in);
	
	// Create a ragged array defined by the users entry
	int[][] studentCreditHrsArr = new int[3][];
	
	// Get number of students for each class
	System.out.print("Enter the number of Students in class number 1 : ");
	int class1 = stdin.nextInt();
	studentCreditHrsArr[0] = new int[class1];
	
	System.out.print("Enter the number of Students in class number 2: ");
	int class2 = stdin.nextInt();
	studentCreditHrsArr[1] = new int[class2];
	
	System.out.print("Enter the number of Students in class number 3: ");
	int class3 = stdin.nextInt();
	studentCreditHrsArr[2] = new int[class3];
	
	// Get user input for each student in each class
	getInput(studentCreditHrsArr);
	
	// Print the Array
	System.out.println("\nThe credits for each class is: ");
    for (int row = 0; row < studentCreditHrsArr.length; row++){
        System.out.print("Class #"+ (row + 1) + ") ");
        for (int col = 0; col < studentCreditHrsArr[row].length; col++){
        	System.out.print(studentCreditHrsArr[row][col] + " ");
      } // eoInnerFor
      System.out.println(); // end of output for one row
	} // eoOuterFor
	
	// Calc total credtis for all classes, store in int variable
	int totalStudentCreditHrs = calcInput(studentCreditHrsArr);
	
	// Print the total # of crdits to the console
	System.out.println("Total credits = "
			+ totalStudentCreditHrs);
	
	// close scanner object
	stdin.close();
	
	}//eo_mainMethod

	// Get user input Method
	public static void getInput(int[][] classNum){
		Scanner userInput = new Scanner(System.in);
		for(int row = 0; row < classNum.length; row++){
			System.out.print("For Class #" + (row+1) + ", enter the "
					+ "credits for " + classNum[row].length + " students: ");	  
			for (int col = 0; col < classNum[row].length; col++){
				classNum[row][col] = userInput.nextInt();
			}// eo_InnerFor
		}//eo_OuterFor
		// close scanner
		userInput.close();
	}//eo_getInputMethod
	
	// Calc total input Method
	public static int calcInput(int[][] classNum){
		int total = 0;
		for(int row = 0; row < classNum.length; row++){
			for(int col = 0; col < classNum[row].length; col++){
				total += classNum[row][col];
			}//eo_InnerFor
		}//eo_OuterFor
		
		
		// return total from ragged array
		return total;
	}//eo_CalcInputMethod
	
}//eo_Hw7Class

