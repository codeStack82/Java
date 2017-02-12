// Tyler Hunt
// Advanced java
// OCCC Spring 2017
// Sort and Merge Homework - Part 2
// Due: 2/12/17 

import java.util.Scanner;
import java.util.Arrays;

public class ArrayWorksheet_Week3 {
    
public static void displayArray(int a []){
    
    for(int i = 0; i < a.length; ++i){
        System.out.printf("%4d", a[i]);
    }
    System.out.println();
    
}
    
public static void displayLongArray(int a []){
    if ( a.length <= 200 ){
        for(int i = 0; i < a.length; ++i){
            if ( i%10 == 0 ){
            System.out.println();
            }
            System.out.printf("%7d", a[i]);
        }
    }
        else{
        for(int i = 0; i < 100; ++i){
            if ( i%10 == 0 ){
            System.out.println();
            }
            System.out.printf("%7d", a[i]);
        }
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
        System.out.println();
  }
    
public static int[] generateDESCSortedArray(){
    int a[] = new int[1000];
    for(int i = 1000; i <1; --i){
        a[i] = i;
    }
    return a;
}

public static int[] generateASCSortedArray(){
    int a[] = new int[1000];
    for(int i = 0; i < 1000; ++i){
        a[i] = i;
    }
    return a;
}

public static int[] generateRandomArray(){
    int [] numbers = new int[1000];

    for (int i = 0; i < numbers.length; i++) {
        numbers[i] = (int)(Math.random()*1000);
    }
    
    return numbers;
}

public static void exchangeSort(int arr []){
    int temp = 0;
    int comp = 0;
    int exch = 0;
    long startTime = 0;
    long endTime = 0;
    
    startTime = System.currentTimeMillis();
    for(int k = 1; k < arr.length; ++k){
        //displayArray(arr);
        for(int i = 0; i < arr.length - k; ++i){
        comp++;
        if ( arr[i] > arr[i+1] ){
            temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
            exch++;
        }
        
        }
    }
    endTime = System.currentTimeMillis();
    System.out.println("\tRun time: " + (endTime - startTime) + " milliseconds");
    System.out.println("\tElement count: " + arr.length);
    System.out.println("\tComparisons : \t" + comp);
    System.out.println("\tExchanges: \t" + exch);
}

public static void insertionSort(int[] arr){
    int temp;
    
    int comp = 0;
    int exch = 0;
    
    long startTime = 0;
    long endTime = 0;
    
    startTime = System.currentTimeMillis();
    for (int i = 1; i < arr.length; i++) {  
        // displayArray(arr);
        for(int j = i ; j > 0 ; j--){
            comp++;
            if(arr[j] < arr[j-1]){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                exch++;
            }
            
            
        }
    }
    endTime = System.currentTimeMillis();
    System.out.println("\tRun time: " + (endTime - startTime) + " milliseconds");
    System.out.println("\tElement count: " + arr.length);
    System.out.println("\tComparisons : \t" + comp);
    System.out.println("\tExchanges: \t" + exch);
}

public static void selectionSort(int[] arr){
    //displayArray(arr);
    int comp = 0;
    int exch = 0;
    
    long startTime = 0;
    long endTime = 0;
    
    startTime = System.currentTimeMillis();
    for (int i = 0; i < arr.length - 1; i++)
    {
        int index = i;
        for (int j = i + 1; j < arr.length; j++){
            
            if (arr[j] < arr[index])
                index = j;
                comp++;             //++comparison counter
        }
    
        int smallerNumber = arr[index]; 
        arr[index] = arr[i];
        arr[i] = smallerNumber;
        exch++;                     //++exchange counter
//            displayArray(arr);
    }
    endTime = System.currentTimeMillis();
    System.out.println("\tRun time: " + (endTime - startTime) + " milliseconds");
    System.out.println("\tElement count: " + arr.length);
    System.out.println("\tComparisons : \t" + comp);
    System.out.println("\tExchanges: \t" + exch);
}

    private static void quickSort(int[] arr, int first, int last) {
        int split = partition(arr, first, last);
        
        if (first < split)
            quickSort(arr, first, split);      // left subarray
        if (last > split + 1)
            quickSort(arr, split + 1, last);   // right subarray
        


    }

    //quick sort helper
    private static int partition(int[] arr, int first, int last){
        int pivot = arr[(first + last)/2];
        int i = first - 1;  // index going left to right
        int j = last + 1;   // index going right to left
        while (true) {
            do { i++;
                    } while (arr[i] < pivot);
                    do {
                        j--;
                    } while (arr[j] > pivot);
                    if (i < j)
                        swap(arr, i, j);
                    else
                        return j;   // arr[j] = end of left array
            }
    }
    
    //quick sort helper
    public static void swap(int[] arr, int a, int b) { int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public static void main(String[] args) {
        
        System.out.println("Exchange Sort");
        
        //Generate temp array and sort
        System.out.println("HW Array");
        int[] exSort1 = new int[]{12,5,11,19,4,7,8,10,9,6,22,2,9,1,32};
        exchangeSort(exSort1);
        System.out.println();
        
        //Generate random array and sort
        System.out.println("Random Array (1000e)");
        int [] exSort2 =  generateRandomArray();
            exchangeSort(exSort2);
        System.out.println(); 
 
        //Generate sorted ASC array and sort
        System.out.println("Sorted ASC Array (1000e)");
        int [] exSort3 =  generateASCSortedArray();
            exchangeSort(exSort3);
        System.out.println(); 
            
        //Generate sorted DESC array and sort
        System.out.println("Sorted DESC Array (1000e)");
        int [] exSort4 =  generateDESCSortedArray();
            exchangeSort(exSort4);
        System.out.println();
        
        System.out.println("-----------------------------------------------");
        System.out.println();
        
        System.out.println("Insertion Sort");
        //Generate temp array and sort
        System.out.println("HW Array");
        int[] inSort1 = new int[]{12,5,11,19,4,7,8,10,9,6,22,2,9,1,32};
        insertionSort(inSort1);
        System.out.println();
        
        //Generate random array and sort
        System.out.println("Random Array (1000e)");
        int [] inSort2 =  generateRandomArray();
            insertionSort(inSort2);
         System.out.println();
        
        //Generate sorted DESC array and sort
        System.out.println("Sorted ASC Array (1000e)");
        int [] inSort3 =  generateASCSortedArray();
            exchangeSort(inSort3);
        System.out.println();
        
        //Generate sorted DESC array and sort
        System.out.println("Sorted DESC Array (1000e)");
        int [] inSort4 =  generateDESCSortedArray();
            exchangeSort(inSort4);
        System.out.println();
        
        System.out.println("-----------------------------------------------");
        System.out.println();
        
        System.out.println("Selection Sort");
        
        //Generate temp array and sort
        System.out.println("HW Array");
        int[] sSort1 = new int[]{12,5,11,19,4,7,8,10,9,6,22,2,9,1,32};
        selectionSort(sSort1);
        System.out.println();
        
        //Generate random array and sort
        System.out.println("Random Array (1000e)");
        int [] sSort2 =  generateRandomArray();
            selectionSort(sSort2);
        System.out.println();
            
        //Generate srted DESC array and sort
        System.out.println("Sorted ASC Array (1000e)");
        int [] sSort3 =  generateASCSortedArray();
            selectionSort(sSort3);
        System.out.println();
            
        //Generate srted DESC array and sort
        System.out.println("Sorted DESC Array (1000e)");
        int [] sSort4 =  generateDESCSortedArray();
            selectionSort(sSort4);
        System.out.println();
        
        System.out.println("-----------------------------------------------");
        System.out.println();
        
        System.out.println("Quick Sort");
        long startTime = 0;
        long endTime = 0;
        
        //Generate temp array and sort
        System.out.println("HW Array");
        int[] qSort1 = new int[]{12,5,11,19,4,7,8,10,9,6,22,2,9,1,32};
            quickSort(qSort1,0,qSort1.length-1);
        
        //Generate random array and sort
        System.out.println("Random Array (1000e)");
        int [] qSort2 =  generateRandomArray();
            quickSort(qSort2,0, qSort2.length-1);
            
        //Generate sorted ASC array and sort 
        System.out.println("Sorted ASC Array (1000e)");
        int [] qSort3 =  generateASCSortedArray();
            quickSort(qSort3,0, qSort3.length-1);
        
        //Generate sorted DESC array and sort 
        System.out.println("Sorted DESC Array (1000e)");
        int [] qSort4 =  generateDESCSortedArray();
            quickSort(qSort4,0, qSort4.length-1);

        System.out.println("-----------------------------------------------");
        System.out.println(); 
        
    }//eoMain    
}//eoClass
