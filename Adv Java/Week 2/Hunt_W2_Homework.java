/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 2 Homework
 * Due: 09/10/17
*/

import java.math.BigInteger;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Hunt_W2_Fibonacci{
    public static void main(String [] args){
        String input = "";

        //Display intro message
        introMessage();

        //Get params from cmd or user input
        String[] params = getParams(args);

        //Start Timer~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Start Timer
        long startTime = System.nanoTime();  
        System.out.println("Timer started....");

        //Calculate Fibonaccis ~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Long fval = convertToLong(params[0]);
        // Long fib = fibonacci_loop(fval);
        // Long fib = fibonacci_recursion(fval);
        // Long fib = fibonacci_Long_Memloop(fval);

        BigInteger fval = new BigInteger(params[0]);   
        String fib = fibonacci_BigInt_Memloop(fval);

        // Calculate Factorials ~~~~~~~~~~~~~~~~~~~~~~~~~
        // int fval = convertToInt(params[0]);
        // int fib = factorial_loop_int(fval);

        // Long fval = convertToLong(params[0]);
        // Long fact = factorial_loop_long(fval);

        // BigInteger fval = new BigInteger(params[0]);   
        // String fact = factorial_loop_Big(fval);

        //End timer & calculate elapsed time~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~End Timer
        long estimatedTime = System.nanoTime() - startTime; 
        double seconds = (double) estimatedTime / 1000000000.0;

      
        System.out.println("The Fibonacci of "+ fval + " is " + fib);
        System.out.printf("Elapsed time is %f seconds.\n", seconds);
    }

    public static void introMessage(){
         //Contract 
        //  Print intro message
        //  @return -> void, no output  
        System.out.println("\n~~~~~~~~~~~~ Week 2 Fibonacci & Facorials - Advanced Java Week 2 ~~~~~~~~~~~~\n");
    }

    public static boolean isCmdLine(String [] args){
        //Contract 
        //  @notes:     Check to see if user started progam with cmd inputs
        //  @param      args[], cmd line input array 
        //  @param      isCmd, check if input > 0 and == 3
        //  @return     boolean, predicate
        //  @Tested     8/24/17

        boolean isCmd = false;
        isCmd = (args.length == 1) ? true : false;
        return isCmd;
    }

    public static String [] getParams(String [] args){
         //Contract 
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

    public static String [] get_inputParams(){
        //Contract 
        //  @notes:     If no cmd input then get user input
        //  @return     String array of user input
        //  @Tested     8/25/17


        //Create input scanner
        Scanner input = new Scanner(System.in);
        String [] params = new String[1];

        //Get string param
        System.out.print("Enter a fval number: ");
        params[0] = input.nextLine();

        //Close scanner object
        input.close();

        //return String []
        return params;
    }

    public static int convertToInt(String input){
        //Contract: process cmd input
        int base = 0;
        
        try{
        
            base = Integer.parseInt(input);
            
        }catch(Exception ex){
            //Contract: display error general message and exit
            //print directions
            String msg = "\nThere has been an error with your input values.... " + 
                        "\n\tThe program will now close, Sorry!";
            
            //print
            System.out.println(msg);
            
            System.exit(0);
        }
        return base;
    }

    public static Long convertToLong(String input){
        //Contract: process cmd input
        Long base = 0L;
        
        try{
        
            base = Long.parseLong(input);
            
        }catch(Exception ex){
            //Contract: display error general message and exit
            //print directions
            String msg = "\nThere has been an error with your input values.... " + 
                        "\n\tThe program will now close, Sorry!";
            
            //print
            System.out.println(msg);
            
            System.exit(0);
        }
        return base;
    }
    
    public static long fibonacci_loop(Long num){
        Long n1 = 0L;
        Long n2 = 1L;
        Long n3 = 0L;
        
        //System.out.print(n1+" "+n2); //printing 0 and 1    

        //loop starts from 2 because 0 and 1 are already printed        
        for(int i = 2; i <= num; ++i){    
            n3 = n1 + n2;    
            n1 = n2;    
            n2 = n3;    
        }  
        return n3;
    }

    public static long fibonacci_recursion(long n){
        long result;
            if(n<1){
                throw new IllegalArgumentException("Cannot compute fibonacci of negative index or 0");
            }
            else if(1==n || 2==n){
                result = 1;
            }
            else{
                result = fibonacci_recursion(n-1) + fibonacci_recursion(n-2);
            }
        return result;
    }

    public static long fibonacci_Long_Memloop(long n, BigInteger fin []){
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
                        c = a + b;
                        a = b;
                        b = c;
                }

                result = c;
                
            }
        return result;
    }

    public static String fibonacci_BigInt_Memloop(BigInteger n){
        BigInteger result = BigInteger.ZERO;
        BigInteger big_one = BigInteger.valueOf(1);
        BigInteger big_two = BigInteger.valueOf(2);
 
            if(n.compareTo(BigInteger.ONE) < 1){
                throw new IllegalArgumentException("Can not compute fibonacci of negative index or 0");
            }
            else if(n.equals(big_one) || n.equals(big_two)){
                result = BigInteger.ONE;
            }
            else{
                BigInteger a = BigInteger.ONE;
                BigInteger b = BigInteger.ONE;
                BigInteger c = BigInteger.ONE;
          
                for(BigInteger i = new BigInteger("3"); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)){ 
                        c = a.add(b);
                        a = b;
                        b = c;
                        //System.out.println(c);  
                    }
                result = c;
            }
        return result.toString();
    }

    public static int factorial_loop_int(int n){
        int factorial = 1;
        if(n<0){
            throw new IllegalArgumentException("Cannot compute factorial of negative number");
        }
        else if(n > 0){
            for(int i = 1; i <= n; ++i){
                if(factorial <= Integer.MAX_VALUE){
                    factorial *= i;   
                }else{
                    factorial = 0;
                }
            }
        }
        return factorial;
    }

    public static Long  factorial_loop_long(Long n){
        Long factorial = 1L;
        if(n<0){
            throw new IllegalArgumentException("Cannot compute factorial of negative number");
        }
        else if(n > 0){
            for(int i = 1; i <= n; ++i){
                factorial *= i;
            }
        }
        return factorial;
    }

    public static long factorial_recursive_long(Long n){
        long result = 1L;
        if(n<0){
            throw new IllegalArgumentException("Cannot compute factorial of negative number");
        }
        else if(0 == n){
            result = 1L;
        }
        else{
            result = n * factorial_recursive_long(n-1L);
        }
        return result;
    }

    public static String factorial_loop_Big(BigInteger n) {
        BigInteger result = BigInteger.ONE;

        while(!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }
        return result.toString();
    }
}

