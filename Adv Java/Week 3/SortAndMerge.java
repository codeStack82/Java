// Tyler Hunt
// Advanced java
// OCCC Spring 2017
// Sort and Merge Homework - Part 1
// Due: 9/10/17

import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;


public class SortAndMerge {
    public static int count = 0;
    public static void main(String[] args) {
        //Desktop test files
            // /Users/Ty/Desktop/Java Temp code/Adv Java/Week 2/array1.txt
            // /Users/Ty/Desktop/Java Temp code/Adv Java/Week 2/array2.txt
            
        //Welcome message and directions
        System.out.println("Welcome to the Sort and Merge console Application!");
        System.out.println();
            
        //File names
        String firstFile = get_fileName();
        String secondFile = get_fileName();
        String thirdFile = get_fileName();
        thirdFile += ".txt";

        try{
            //Get file information  
            Scanner f1 = new Scanner(new File(firstFile));
            Scanner f2 = new Scanner(new File(secondFile));
            
            //get array size ->> from first line
            int size1 = f1.nextInt();
            int size2 = f2.nextInt();
            int size3 = size1 + size2;
             
            //Create arrays
            int firstArray [] = new int [size1];
            int secondArray [] = new int [size2];
            int thirdArray [] = new int[size3];
            
            //Read in contents from array 1-------------------------------------
            for(int i = 0; i < firstArray.length; ++i){
                 //System.out.println(i);
              firstArray[i] = f1.nextInt();
            }
            //Sort array 1
            System.out.print("\nSorting Arrary 1.........");
            mergeSort(firstArray);
            System.out.print("Array 1 Sorted!");
            System.out.println();
            //print_Top_and_Btm_Array(firstArray);
            
            //Read in contents from array 2-------------------------------------
            for(int i = 0; i < secondArray.length; ++i){
              secondArray[i] = f2.nextInt();
            }
             //Sort array 2
            System.out.print("Sorting Arrary 2.........");
            mergeSort(secondArray);
            System.out.print("Array 2 Sorted!");
            //print_Top_and_Btm_Array(secondArray);
            System.out.println();
            
            //Merge first 2 arrays into the third
            System.out.print("Merging arrays 1 and 2 into array 3!");
            mergeArrays(firstArray, secondArray, thirdArray);
            System.out.print("Arrays Merged!");
            System.out.println();
            
            //Sort & merge third array
            System.out.print("Sorting Arrary 3.........");
            mergeSort(thirdArray);
            System.out.print("Array 3 Sorted!");
            System.out.println();
            //print_Top_and_Btm_Array(thirdArray);
            
            //Print third array to a file
            try{
                System.out.println("Exporting merged and sorted array data............");
                writer(thirdFile, thirdArray);
                System.out.println("New Array merged, sorted and exported!");
            }catch(IOException ex){
                System.out.println();
                System.out.println("\tError: " + ex.toString());
            }
          
        }//Catch file exception if not file found
        catch(FileNotFoundException e){
            System.out.println();
            System.out.println("\tError: " + e.toString());
            System.out.println("\tMake sure you enter the correct file path.");
            System.out.println("\tPlease try again.");
        }
    }
    
    //Print entire array ->> for test purposes
    public static void print_Array(int a []){
      
        for(int i = 0; i < a.length; ++i){
          if ( i%10 == 0 ){
            System.out.println();
          }
          System.out.printf("%7d", a[i]);
        }

        System.out.println();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println();
      }
    
    //Default print array function ->> for possible large arrays
    public static void print_Top_and_Btm_Array(int a []){
        if ( a.length <= 200 ){
            for(int i = 0; i < a.length; ++i){
              if ( i%10 == 0 ){
                System.out.println();
              }
              System.out.printf("%7d", a[i]);
            }
        }
         else{
            //print first 100
            for(int i = 0; i < 100; ++i){
              if ( i%10 == 0 ){
                System.out.println();
              }
              System.out.printf("%7d", a[i]);
            }
            //print last 100
            System.out.println();
            System.out.println("----------------------------------------------");
            for(int i = a.length - 100; i < a.length; ++i){
              if ( i%10 == 0 ){
                System.out.println();
              }
              System.out.printf("%7d", a[i]);
            }
        }
          System.out.println();
      }
    
    //Write to new file
    public static void writer (String fileName, int[]x) throws IOException{
        //Save file to user desktop
        System.getProperty("user.home");
        String userHomeFolder = System.getProperty("user.home");
        //System.out.println(userHomeFolder);
        File textFile = new File(userHomeFolder, fileName);
        
        BufferedWriter outputWriter;
        outputWriter = new BufferedWriter(new FileWriter(textFile));
      
        for (int i = 0; i < x.length; i++) {
    
            outputWriter.write(x[i]+" ");
            if ( i%10 == 0 ){
                outputWriter.newLine();
            }else{
                outputWriter.write(x[i]+" ");
            }
        }
        
        outputWriter.flush();  
        outputWriter.close();  
    }
   
    //Get file name ->> return file name
    public static String get_fileName(){
        //iterate counter
        count++;
        String counted=""; 
        
        //file name
        String fileName = "";
        try{
            //Check count then build string
            if(count == 1){
                counted = "first";
            }else if(count == 2){
                counted = "second";
            }else if(count == 3){
                counted = "third";
            }
            
            //Prompt string
            String prompt = "Please enter the " + counted +" file name: ";

            //Create scanner to get filename
            Scanner s = new Scanner(System.in);
            //Scanner f = new Scanner(new File(fileName))

            //Display prompt
            System.out.print(prompt);
            
            //get file name
            fileName = s.nextLine();

            return fileName;
        }catch(Exception ex){
            System.out.println();
            System.out.println("There has been an error!");
            System.out.println("\tError: " + ex.toString());
        }
       return fileName = ""; 
    }
    
    //Method to sort array using merge sort
    public static void mergeSort(int[] arr){
        if(arr.length > 1){
            
            //Split array and recursivly sort left half
            int[] leftHalf = new int[arr.length / 2];
            System.arraycopy(arr, 0, leftHalf,0, arr.length / 2);
            mergeSort(leftHalf);
            
            //Get right hlaf length
            int rightHalfLength = arr.length - arr.length /2;
            
            //Get right half and recursivly sort right half
            int[] rightHalf = new int[rightHalfLength];
            System.arraycopy(arr, arr.length / 2, rightHalf,0, rightHalfLength);
            mergeSort(rightHalf);
            
            //Merge arrays together and return
            mergeArrays(leftHalf, rightHalf, arr);
        }
    }
    
    //Method to merge arrays
    public static void mergeArrays(int[] arr1, int[] arr2, int[] temp){
        int arrLength1 = 0;
        int arrLength2 = 0;
        int arrlength = 0;
        
        //While still data to merge
        while(arrLength1 < arr1.length && arrLength2 < arr2.length){
            
            //Check each value is each half array and 
            //Combine into the temp[]
            if(arr1[arrLength1] < arr2[arrLength2]){
                temp[arrlength++] = arr1[arrLength1++];
            }else{
                temp[arrlength++] = arr2[arrLength2++];
            }
        }
        
        //Get rest of arr1 into temp[]
        while(arrLength1 < arr1.length){
            temp[arrlength++] = arr1[arrLength1++];
        }
        
        //get rest of arr2 into temp[]
        while(arrLength2 < arr2.length){
            temp[arrlength++] = arr2[arrLength2++];
        }
    }
}
