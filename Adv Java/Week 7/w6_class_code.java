/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 6
 * Due: 10/1/2107
 * Hunt_W6_Classes
*/
import java.util.Scanner;

public class w6_class_code{
    public static void main(String [] args){

        int n, d;
        Scanner s = new Scanner(System.in);

        System.out.print("Please enter an integer: ");
            n = s.nextInt();
        System.out.print("Please enter an integer: ");
            d = s.nextInt();

        try{
            System.out.println("The quotient is: " + n + "/" + d + " is " + quotient(n, d));
        }catch(ArithmeticException e){
            System.out.println("Exception Caught");
            System.out.println(e.toString());
        }

    }//eomain

    public static int quotient(int n, int d){
        //Precondition > o
        if(d !=0 ){
            return (n/d);
        }else{
            throw new ArithmeticException("OH No Divisor is 0");
        }
    }
}



/** Class Notes:
 *  High cohesion
 *  Low coupling
 *  "No Suprises"
 *  
 * Error handling:
 *  Ways to hand errors:
 *      X-return an Error
 *      X-Displayy an error message
 *      X-Halt
 *      ------------
 *  Best case - Exceptions !!!!!
 * 
 * 
 * When to throw an exception:
 *      when the preconditions are not met
 * 
 * Exception keywords:
 *      Throw -> an error
 * 
 * Exception types: 
 *      Checked and UnChecked
 * 
 * 
 * 
 */