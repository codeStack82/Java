/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Class Example
 * Due: 09/17/17
 * Week 3 Part 2
 * Reference Prime val check
 *      http://numbers.computation.free.fr/Constants/Primes/primeonline.html
*/

import java.util.Scanner;

import com.sun.javafx.runtime.SystemProperties;

import java.util.Arrays;

public class Hunt_W3_SieveOfEratosthenes { 
    public static void main(String[] args) {
     
        Scanner input = new Scanner(System.in);
        String get_startNum = "2";
        String get_endNum = "0";
        
        int startNum = 2;
        int endNum = 0;
        int primeCount = 0;
        
        //Display intro message
        introMessage();
        
        //Get start num and parse
        System.out.print("Please enter a start number > 1: ");
            get_startNum = input.next();
            startNum = get_Num(get_startNum);
        
        //get end num and parse
        System.out.print("Please enter an end number: ");
            get_endNum = input.next();
            endNum = get_Num(get_endNum);

        //Ensure start and end numbers are correct    
        if(startNum > 1 && endNum > 2 && endNum > startNum){
            
            int size = endNum + 1;
            
            //Creat and initialize prime boolean array
            boolean[] primeArray = new boolean[size];
            
            //Start time
            long startTime = System.nanoTime();  
            
            //Default array values to true
            Arrays.fill(primeArray, Boolean.TRUE);
            
            //Loop through and test values for prime
            for(int k = 2; k <= endNum/k; ++k){
                if(primeArray[k]){
                    for(int i = k; i <= endNum/k; ++i){
                        //num is not a prime -> set to false
                        primeArray[k * i] = false;
                    }
                }
            }
        
            //End time
            long estimatedTime = System.nanoTime() - startTime; 
            double seconds = (double) estimatedTime / 1000000000.0;
            
            //Get prime count and display results
            primeCount = primeCounter(primeArray, startNum);
            
            //Display total result
            System.out.println("\nThere are " + primeCount + 
                    " prime(s) that are > " + startNum + " and <= " + endNum);
            
            //Display elapsed time
            System.out.printf("Elapsed time is %f seconds.\n", seconds);
        
        }else{
            if(startNum < 2){
                System.out.println("The start number must be greater than 1!");
                System.out.println("\tSystem exiting......Please try again!");
                System.exit(1);
            }else if(endNum < 2){
                System.out.println("The end number must be greater than 1!");
                System.out.println("\tSystem exiting......Please try again!");
                System.exit(1);
            }else if(endNum < startNum){
                System.out.println("The end number must be greater than the start number!");
                System.out.println("\tSystem exiting......Please try again!");
                System.exit(1);
            }
        }
    }//eoMain
    
    public static void introMessage()
    {//Contract 
        //  Print intro message
        //  @return -> void, no output  
        System.out.println("\n~~~~~~~~~~~~ Sieve of Eratosthenes Program - Advanced Java Week 3 - Part 2 ~~~~~~~~~~~~\n");
    }

    //Get user input string - parse and return if valid
    public static int get_Num(String in)
    {//Contract 
        //  @Notes      Print intro message
        //  @return     int , num  
        int num = 0;
        
        try{
            num = Integer.parseInt(in);
        }catch (NumberFormatException e){
            System.out.println("\tNumber format exception\n\t"+ e.getMessage());
            System.out.println("\tSystem exiting......Please try again!");
            System.exit(1);
        }catch(StackOverflowError ex){
            System.out.println("\tStack overflow exception\n\t"+ex.getMessage());
            System.out.println("\tSystem exiting......Please try again!");
            System.exit(1);
        }finally{
           if(num < 2){
                System.out.println("The number must be greater than 1!");
                System.out.println("\tSystem exiting......Please try again!");
                System.exit(1);
            }else{
                return num;
            }   
        }
        return num;
    }
    
    //Get prime number count and 
    public static int primeCounter(boolean[] primes, int startNum)
    {//Contract 
        //  @Notes      Print intro message
        //  @param      bool [] array
        //  @param      int startNum
        //  @return     int, no output  

        int count = 0;
        System.out.println("\nPrint First 100 Primes------------------------------------------------------------------------------------\n");
        for(int i = 2; i < primes.length; ++i){
            //Count primes and print first 100
            if(primes[i] && i >= startNum){
                count++;
                //Print first 100
                if(count <= 100){
                    if(count % 10 == 0){
                        System.out.printf("%10d\n", i);
                    }else{
                        System.out.printf("%10d", i); 
                    }  
                }
            }
        }
        System.out.println("\nPrint Last 100 Primes------------------------------------------------------------------------------------\n");
        int lastCount = 0;
        for(int i = primes.length-100; i < primes.length; ++i){
            //Print last 100
            lastCount++;
                if(lastCount % 10 == 0){
                    System.out.printf("%10d\n", i);
                }else{
                    System.out.printf("%10d", i); 
                }
        
            }
        

        return count;         
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
              System.out.printf("%10d", a[i]);
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

}//eoClass
