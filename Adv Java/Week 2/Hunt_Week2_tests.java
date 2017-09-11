//Zack Wise
//java
//spring
//loop and recursion
//factorial

import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Hunt_Week2_tests
{
    public static void main(String[] args){
            int n = 1;
            Long n_long = 1L;
            BigInteger big_n = BigInteger.ONE;
                if(args.length>1){
                    System.out.println("Usage: java demo <int>");
                    System.exit(1);
                }
                else if(args.length==1){
                    n = Integer.parseInt(args[0]);
                }
                else{   
                    
                    Scanner s = new Scanner(System.in);
                    System.out.print("Please enter an integer: ");
                
                    n_long = s.nextLong();
                    big_n = s.nextBigInteger();
                    long startTime = System.nanoTime();  
                    System.out.println("\tTimer started....");
                    
                    //HW part 1 
                    //System.out.println("\t"+ n_long + "! = " + factorial_loop_long(n_long));
                    //System.out.println(n_long + "! = " + factorial_recursive_long(n_long));

                    System.out.println("\t"+big_n + "! = " + factorial_loop_Big(big_n));

                    long estimatedTime = System.nanoTime() - startTime; 
                    double seconds = (double) estimatedTime / 1000000000.0;
                    
                    // Long max = Long.MAX_VALUE;
                    // System.out.printf(max.toString());
                    System.out.printf("\tElapsed time is %f seconds.\n", seconds);
                }
        } 


    public static int factorial_loop_int(int n){
        int factorial = 1;
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
    
    //Memoitized loop
    public static int fib_loop(int n){
        int result;
            if(n<1){
                throw new IllegalArgumentException("Cannot compute fibonacci of negative index or 0");
            }
            else if(1==n || 2==n){
                result = 1;
            }
            else{
                int a = 1;
                int b = 1;
                int c = 1;
                for(int i=3; i<=n; ++i){
                    c=a+b;
                    a=b;
                    b=c;
                }
                result = c;
            }
        return result;
    }    
    public static int fib_recursion(int n){
       
        int result;
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

    public static Long fib_recursion(Long n){
       
        Long result = 1L;
            if(n<1){
                throw new IllegalArgumentException("Cannot compute fibonacci of negative index or 0");
            }
            else if(1==n || 2==n){
                result = 1L;
            }
            else{
                    result = fib_recursion(n-1) + fib_recursion(n-2);
            }
        return result;
    }
}