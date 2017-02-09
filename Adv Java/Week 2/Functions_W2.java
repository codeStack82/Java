/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Spring 2017
 * Assignment 
 * Due: 2/5/17
 */

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Functions_W2 {
    
    public static long factorial_loop(int n){
        long factorial = 1;
        if(n<0){
            throw new IllegalArgumentException("Cannot compute factorial of negative number");
        }
        else if(n>0){   
            for(int i = 1; i <= n; ++i){
                if(factorial>0){
                    factorial *= i;
                }else{
                    return factorial;
                }
                
                //System.out.print("("+factorial + " " + i + ") ");
            }
        }
        return factorial;
    }

    public static long factorial_recursive(long n){
        long result =0;
        if(n<0){
            throw new IllegalArgumentException("Cannot compute factorial of negative number");
        }
        else if(0 == n){
            result = 1;
        }
        else{
            result = n * factorial_recursive(n-1);
        }
        return result;
    }
    
    public static long fib_Loop(long n){
        long result=0;
        long num1 = 0;
        long num2 = 1;
         for (long i = 1; i <= n; i++) {
            num1 = num1 + num2;
            num2 = num1 - num2;
            
            result = num1;
        }
        return result;
    }
    
    public static long fib_Long_Memloop(long n){
        long result = 0;
            if(n<1){
                throw new IllegalArgumentException("Cannot compute fibonacci of negative index or 0");
            }
            else if(1==n || 2==n){
                result = 1;
            }
            else{
                long a = 1;
                long b = 1;
                long c = 1;
                for(long i=3; i<=n; ++i){
                        c=a+b;
                        a=b;
                        b=c;
                }

                result = c;
                
            }
        return result;
    }
    
    private static BigInteger fib_BigInt_MemLoop(int n) {
        BigInteger x = BigInteger.ONE;
        if(n<1){
            throw new IllegalArgumentException("Cannot compute fibonacci of negative index or 0");
        }else if(1 ==n || 2 ==n){
            return x;
        }
        else{
            BigInteger a = BigInteger.ZERO;
            BigInteger b = BigInteger.ONE;
            for (int i = 0; i < n; i++) {
                    BigInteger c = a.add(b);
                    a = b;
                    b = c;
            }
            return a;
        }
    }
    
    public static long fib_recursion(long n){
        long result;
            if(n<1){
                throw new IllegalArgumentException("Cannot compute fibonacci of negative index or 0");
            }
            else if(1==n || 2==n){
                result = 1;
            }
            else{
                    result = fib_recursion(n-1) + fib_recursion(n-2);
            }
        return result;
    }

    public static void mainMethod(int n){
        //Start timer
        long startTime = System.nanoTime();  

        //Display output    -Change out below function as needed
        System.out.println( n + "! = " + fib_BigInt_MemLoop(n));

        //Calculate elapsed time
        long estimatedTime = System.nanoTime() - startTime;        
        double seconds = (double)estimatedTime / 1000000000;

        //Display ouputs
        System.out.println("The elapsed time is " + (seconds)  + " seconds.");
    }
  
    public static void main(String[] args) {
            int  n = 0;
             if(args.length>1){
                 System.out.println("Usage: java demo <int>");
                 System.exit(1);
             }
             else if(args.length > 0 && args.length < 2){
                 try{
                     
                    n = Integer.parseInt(args[0]);
                    
                    mainMethod(n);
                    
                 }catch(Exception ex){
                    System.out.println("There appears to have been an error.");
                    System.out.println("\tJava error type: "+ ex);
                    System.exit(1);
                 }
             }
             else{
                 try{
                     Scanner s = new Scanner(System.in);
                     System.out.print("Please enter a number: ");
                     n = s.nextInt();

                     mainMethod(n);

                 }catch(Exception ex){
                     System.out.println("There appears to have been an error.");
                     System.out.println("\tJava error type: "+ ex);
                     System.exit(1);
                 }

             }
        } 
    }
    

