// Tyler Hunt
// Advanced java
// OCCC Spring 2017
// Sort and Merge Homework - Part 2
// Due: 2/12/17 

import java.util.Scanner;
import java.util.Arrays;

public class SieveOfEratosthenes {

 
    public static void main(String[] args) {
     
        Scanner input = new Scanner(System.in);
        String get_startNum = "2";
        String get_endNum = "0";
        
        int startNum = 2;
        int endNum = 0;
        int primeCount = 0;
        
        //Intro Message
        System.out.println("Welcome the the Sieve of Eratosthenes!");
        
        //Get start num and parse
        System.out.print("Please enter a start number > 1: ");
            get_startNum = input.next();
            startNum = get_Num(get_startNum);
        
        //get end num and parse
        System.out.print("Please enter an end number: ");
            get_endNum = input.next();
            endNum = get_Num(get_endNum);
            
        if(startNum > 1 && endNum > 2 && endNum > startNum){
            
            int size = endNum + 1;
            
            //Creat and initialize prime boolean array
            boolean[] primeArray = new boolean[size];
            
            //Start time
            long start = System.currentTimeMillis();
            
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
            long end = System.currentTimeMillis();
            
            //Get prime count and display results
            primeCount = primeCounter(primeArray, startNum);
            
            //Display total result
            System.out.println("\nThere are " + primeCount + 
                    " prime(s) that are > " + startNum + " and <= " + endNum);
            
            //Display elapsed time
            System.out.println("Elapsed time was " + 
            (Math.round((end-start))/1000) + " seconds." );
        
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
    
    //Get user input string - parse and return if valid
    public static int get_Num(String in){
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
    public static int primeCounter(boolean[] primes, int startNum){
        int count = 0;
         //Count number of primes
         int number = primes.length - 100;
            for(int i = 2; i < primes.length; ++i){
                //Count primes and print
                if(primes[i] && i >= startNum){
                    count++;
                    if(count < 100){
                        if(count % 10 == 0){
                            System.out.printf("%7d\n", i);
                        }else{
                            System.out.printf("%7d", i); 
                        }
                    }
                }
            }
        return count;         
    }
    
}//eoClass
