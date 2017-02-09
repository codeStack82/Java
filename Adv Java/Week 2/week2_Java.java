//Zack Wise
//java
//spring
//loop and recursion
//factorial

import java.util.Scanner;

public class week2_Java
{
    public static int factorial_loop(int n){
        int factorial = 1;
        if(n<0){
            throw new IllegalArgumentException("Cannot compute factorial of negative number");
        }
        else if(n>0){
            for(int i = 1; i <= n; ++i){
                factorial *= i;
            }
        }
        return factorial;
    }

    public static int factorial_recursive(int n){
        int result;
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


    public static void main(String[] args){
            int n = 1;
                if(args.length>1){
                    System.out.println("Usage: java demo <int>");
                    System.exit(1);
                }
                else if(args.length==1){
                    n = Integer.parseInt(args[0]);
                }
                else{   
                    
                    Scanner s = new Scanner(System.in);
                    System.out.println("Please print an integer");
                    n = s.nextInt();
                }

          
                    long t1 = System.currentTimeMillis();

                    System.out.println(n + "! = " + factorial_recursive(n));

                    long t2 = System.currentTimeMillis();

                    
                    System.out.println("The elapsed time is " + ( t2 - t1 ) / 1000  + " seconds.");
               
        } 
        
  
}