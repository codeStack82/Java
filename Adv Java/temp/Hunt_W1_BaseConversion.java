/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Class Example
 * Due: 08/23/17
*/

/* Week 1 - Outline
    - Check inputs 
        - cmd line inputs?
        - User enter input?

    - Intro message
        - if cmd
            - get inputs

        - if user input 
            - get inputs
                - prompt for string to conv, base, output
    
    - Validate inputs
        - Check if string is valid against initial base 
            - If valid 
                - Convert to base 10 (Use BigInt)
                - Convert to target base (use BigInt)
                - Return value as String from BigInt 
            - Else return error message
                - Wrap in do/while to get another set of inputs 
*/

import java.math.BigInteger;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Hunt_W1_BaseConversion{
    public static void main(String [] args){

        //Display intro message
        introMessage();

        //Check if user entered cmd input
        boolean is_cmdLine = isCmdLine(args);
        System.out.println(is_cmdLine);

        
    }//eoMain

    public static void introMessage(){
        //Contract 
        //  Print intro message 
        System.out.println("\t\tBase Conversion Program - Advanced Java Week 1");
        System.out.println("This Program converts a string input from it's' initial base to a new target base.");
        System.out.println("Please, enter a String, a Base (integer), and a target base (integer) for conversion.");
    }

    public static boolean isCmdLine(String [] args){
        //Contract 
        //  @param -> args[], cmd line input array 
        //  @param -> isCmd, check if input > 0 and == 3
        //  @return ->  true or false
        //  @Tested -> works good!

        boolean isCmd = false;
        isCmd = (args.length > 0 && args.length == 3) ? true : false;
        return isCmd;
    }

}