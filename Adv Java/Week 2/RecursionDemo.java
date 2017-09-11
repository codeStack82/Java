/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Class Example
 * Due: xx/xx/xx
*/

/* Week x - Outline
   temp code tested - 8/26/17
*/

import java.math.BigInteger;
import java.util.Scanner;
import java.util.InputMismatchException;

public class RecursionDemo{
    public static void main(String [] args){
        int i = 0;
     
        //Display intro message
        introMessage();

        //Get params from cmd or user input
        String[] params = getParams(args);
        int fact = Integer.parseInt(params[0]);
        int answer = fac_rec(fact);
        System.out.println(answer);

        //Print params from either cmd input or user input
        //printArray(params);
    }
    public static int fac_rec(int n){
        int result = 1;
        if(n > 0){
            result = n * fac_rec(n-1);
        }
        return result;
    }

    public static void introMessage(){
         //Contract 
        //  Print intro message
        //  @return -> void, no output  
        System.out.println("\n~~~~~~~~~~~~ Recursion Demo Program - Advanced Java Week 2 ~~~~~~~~~~~~\n");
    }


    public static boolean isCmdLine(String [] args){
        //Contract 
        //  @notes:     Check to see if user started progam with cmd inputs
        //  @param      args[], cmd line input array 
        //  @param      isCmd, check if input > 0 and == 3
        //  @return     boolean, predicate
        //  @Tested     8/24/17

        boolean isCmd = false;
        isCmd = (args.length > 0 && args.length == 1) ? true : false;
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
        System.out.print("\tEnter the initial base (Integer):  ");
        params[0] = input.nextLine();


        //Close scanner object
        input.close();

        //return String []
        return params;
    }

    public static void printArray(String[] arr){
        System.out.println("User Parameters:");
        for (String i : arr) {
            System.out.println("  "+i);
        }
    }
}

