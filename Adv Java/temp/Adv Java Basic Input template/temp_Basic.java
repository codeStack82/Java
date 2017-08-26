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

public class temp_Basic{
    public static void main(String [] args){
        String userStr = "";
        int initial_Base = 0;
        int target_Base = 0;


        //Display intro message
        introMessage();

        //Get params from cmd or user input
        String[] params = getParams(args);

        //Print params from either cmd input or user input
        printArray(params);

    }
    public static void introMessage(){
        //Contract 
        //  Print intro message 
        System.out.println("\n~~~~~~~~~~~~ Basic XXX Program - Advanced Java Week X ~~~~~~~~~~~~\n");
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

    public static String [] getParams(String [] args){
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
        //  Asks for 3 inputs from user
        //  @params -> String, asks for user input
        //  @params -> String, asks for user input        
        //  @params -> String, asks for user input
        //  @return -> String[] with user input values


        //Create input scanner
        Scanner input = new Scanner(System.in);
        String [] params = new String[3];

        //Get string param
        System.out.print("\tEnter a string to convert (String): ");
        params[0] = input.nextLine();

        //Get initial base param
        System.out.print("\tEnter the initial base (Integer):  ");
        params[1] = input.nextLine();

        //Get target base param
        System.out.print("\tEnter the new target base (Integer):  ");
        params[2] = input.nextLine();

        return params;
    }

    public static void printArray(String[] arr){
        System.out.println("User Parameters:");
        for (String i : arr) {
            System.out.println("  "+i);
        }
    }


}

