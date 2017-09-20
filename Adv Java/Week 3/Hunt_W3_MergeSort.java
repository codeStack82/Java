/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Class Example
 * Due: 09/17/17
 * Week 3 Part 1
*/

import java.math.BigInteger;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;
import java.io.BufferedWriter;

public class Hunt_W3_MergeSort{
    public static void main(String [] args){
        //Note: Command line accepts 3 file names 
            // Ex: array1.txt array2.txt results.txt

        //Display intro message
        introMessage();

        //Create large Test File qty = 369667 int
        // createLargeTestFile();

        //Get params from cmd or user input
        String[] params = getParams(args);

        //Create files
        String firstFile = params[0].toString();
        String secondFile = params[1].toString();
        String resultFile = params[2].toString();

        //Time
        long startTime = System.nanoTime();  

        try{
            //Scanner to get file array info
            Scanner f1 = new Scanner(new File(firstFile));
            Scanner f2 = new Scanner(new File(secondFile));

            //Get file sizes
            int size1 = f1.nextInt();
            int size2 = f2.nextInt();
            int size3 = size1 + size2;
            //System.out.printf("size1 %d - size2 %d - size3 %d ", size1, size2, size3);

            //Create arrays for files
            int firstArray [] = new int [size1];
            int secondArray [] = new int [size2];
            int resultArray [] = new int [size3];

            //Read in contents from array 1-------------------------------------
            for(int i = 0; i < firstArray.length; i++){
                firstArray[i] = f1.nextInt();
            }
           
            //Read in contents from array 2-------------------------------------
            for(int i = 0; i < secondArray.length; ++i){
                secondArray[i] = f2.nextInt();
            }

            //Begin Sort 
            System.out.println("\nSorting Arrary 1....\t" + ((System.nanoTime() - startTime)/ 1000000000.0 + " seconds"));
            mergeSort(firstArray);
            System.out.println("Sorting Arrary 2....\t"+ ((System.nanoTime() - startTime)/ 1000000000.0 + " seconds"));
            mergeSort(secondArray);

            //Merge first 2 arrays into the third
            System.out.println("Merging arrays .....\t"+ ((System.nanoTime() - startTime)/ 1000000000.0 + " seconds"));
            mergeArrays(firstArray, secondArray, resultArray);

            //Sort & merge third array
            System.out.println("Sorting Arrary 3....\t"+ ((System.nanoTime() - startTime)/ 1000000000.0 + " seconds"));
            mergeSort(resultArray);

            System.out.println("Sorted and Merged...\t"+ ((System.nanoTime() - startTime)/ 1000000000.0 + " seconds"));
                print_Top_and_Btm_Array(resultArray);

            //Print third array to a file
            try{
                writer(resultFile, resultArray);
                System.out.println("\nArray's merged, sorted and exported!");
                System.out.println("\nTotal Sort/Merge/Export/Print Time = "+ ((System.nanoTime() - startTime)/ 1000000000.0 + " seconds"));
            }catch(IOException ex){
                System.out.println();
                System.out.println("\tError: " + ex.toString());
            }

        }catch(FileNotFoundException e){
            System.out.println();
            System.out.println("\tError: " + e.toString());
            System.out.println("\tMake sure you enter the correct file path.");
            System.out.println("\tPlease try again.");
        }

    }
    public static void introMessage()
    {//Contract 
        //  Print intro message
        //  @return -> void, no output  
        System.out.println("\n~~~~~~~~~~~~ Merge and Sort Program - Advanced Java Week 3 - Part 1~~~~~~~~~~~~\n");
    }

    public static boolean isCmdLine(String [] args)
    {
        //Contract 
        //  @notes:     Check to see if user started progam with cmd inputs
        //  @param      args[], cmd line input array 
        //  @param      isCmd, check if input > 0 and == 3
        //  @return     boolean, predicate
        //  @Tested     8/24/17

        boolean isCmd = false;
        isCmd = (args.length == 3) ? true : false;
        return isCmd;
    }

    public static String [] getParams(String [] args)
    {//Contract 
        //  @notes:     get input from either cmd or user input
        //  @param      args[], cmd line input array or manual user input array
        //  @param      isCmd, boolean
        //  @return     String array of user input
        //  @Tested     8/24/17

        //Check if user entered cmd input
        boolean is_cmdLine = isCmdLine(args);

        if(is_cmdLine){
            return args;
        }else{
            return get_inputParams();
        }
    }

    public static String [] get_inputParams()
    {//Contract 
        //  @notes:     If no cmd input then get user input
        //  @return     String array of user input
        //  @Tested     8/25/17


        //Create input scanner
        Scanner input = new Scanner(System.in);
        String [] params = new String[3];

        //file name message
        System.out.println("Enter a file name with the file extension (ex: fileName.txt)");

        //Get string param
        System.out.print("\tInput file name #1: ");
        params[0] = input.nextLine();

        //Get string param
        System.out.print("\tInput file name #2: ");
        params[1] = input.nextLine();

        //Get string param
        System.out.print("\tResult file name #3: ");
        params[2] = input.nextLine();

        //Close scanner object
        input.close();

        //return String []
        return params;
    }

    public static void print_Top_and_Btm_Array(int a [])
    {//Contract 
        //  @notes:     print top and bottom halfs to large arrays
        //  @param      int a[], array 
        //  @return     void
        
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

    public static void writer (String fileName, int[] x) throws IOException
    {//Contract 
        //  @notes:     Writes int array to a file 
        //  @param      string, file name
        //  @param      int x[], array 
        //  @throws     IOException
        //  @return     void

        //Save file to user desktop
        File textFile = new File(fileName);
        
        BufferedWriter outputWriter;
        outputWriter = new BufferedWriter(new FileWriter(textFile));
        String s = Integer.toString(x.length);
        outputWriter.write(s);

        for (int i = 0; i < x.length; i++) {
            if ( i%10 == 0 ){
                outputWriter.newLine();
            }else{
                outputWriter.write(x[i]+" ");
            }
        }
        
        outputWriter.flush();  
        outputWriter.close();  
    }
    public static void mergeSort(int[] arr)
    {//Contract 
        //  @notes:     Merges sort
        //  @param      int arr1[], array 1
        //  @return     void

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

    public static void mergeArrays(int[] arr1, int[] arr2, int[] temp)
    {//Contract 
        //  @notes:     Merges arrays
        //  @param      int arr1[], array 1
        //  @param      int arr2[], array 2
        //  @param      int temp[], array temp
        //  @return     void

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

