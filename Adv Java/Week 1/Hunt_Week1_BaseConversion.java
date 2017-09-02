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
            - error wrong num inputs

        - if user input (no cmd)
            - get inputs
                - prompt for string to conv, base, output
    
    - Validate inputs
        - Check if string is valid against initial base 
            - If valid 
                - Convert to target base (use BigInt)
                - Return value as String from BigInt 
            - Else return error message
*/

import java.math.BigInteger;
import java.lang.StringBuilder;
import java.util.Scanner;

import jdk.nashorn.internal.runtime.QuotedStringTokenizer;

import java.util.InputMismatchException;

public class Hunt_Week1_BaseConversion{
    public static void main(String [] args){
        String userStr = "";
        int initial_Base = 0;
        int target_Base = 0;

        try{
            //Display intro message
            introMessage();

            //Get params 
            String[] params = getParams(args);

            //Set params
            userStr = params[0].toString();
            initial_Base = convertToInt(params[1].toString());
            target_Base = convertToInt(params[2].toString());

            //Validate inputs
            userStr = formatInputString(userStr);
            
            //Check if user string is of corect base type
            boolean is_ValidBase = isValidBase(userStr, initial_Base);

            if(is_ValidBase){
                // My custom function built using BigInt - Not useing the BigInt built in classes
                String output1 = convertToBaseTen_BigInt(userStr, initial_Base, target_Base); 
                    System.out.println("\nBigInt - Initial base ->  " + initial_Base + ":   " + userStr);
                    System.out.println("BigInt - Target base  ->  " + target_Base + ":  " + output1 +"\n");

                // Testing function to confirm output    
                String output2 = convertBases(userStr, initial_Base, target_Base);
                    System.out.println("Built-In - Initial base ->\t" + initial_Base + ":\t " + userStr);
                    System.out.println("Built-In - Target base  ->\t" + target_Base + ":\t " + output2 +"\n");
            }else{
                System.out.println("\nThe user input string '" + userStr + "' is not of base type " + initial_Base);
                System.out.println("\tSorry, Please try again some other time!");
            }
        }catch(Exception ex){
            System.out.println("Apparently, there has been some sort of wierd/random anolomy is this program????");
            System.out.println("\tThe program will now exit, Sorry!");
            System.exit(1);
        }
    }

    public static void introMessage(){
        //Contract 
        //  @print  prints intro message
        //  @return void
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~ Base Conversion Program - Advanced Java Week 1 ~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("This Program converts a string input from it's initial base to a different target base.\n");
        System.out.println("Enter a string, an initial base (integer), and a target base (integer) for conversion.");
    }

    public static boolean isCmdLine(String [] args){
        //Contract 
        //  @param      args[], cmd line input array 
        //  @param      isCmd, check if input > 0 and == 3
        //  @return     boolean, predicate
        //  @notes:     Check to see if user started progam with cmd inputs

        boolean isCmd = false;
        isCmd = (args.length > 0 && args.length == 3) ? true : false;

        //If number of cmd line input values are incorrect
        String invaid_cmd_message = "";
        if((args.length > 0 && args.length > 3)){
            invaid_cmd_message = "\nInvalid number of command line inputs, Please, manually enter input values:\n";
            System.out.println(invaid_cmd_message);
        }
        return isCmd;
    }

    public static String [] getParams(String [] args){
        //Contract 
        //  @param      args[], cmd line input array or manual user input array
        //  @param      isCmd, boolean
        //  @return     String array of user input
        //  @notes:     get input from either cmd or user input

        //Check if user entered cmd input
        boolean is_cmdLine = isCmdLine(args);

        if(is_cmdLine){
            return args;
        }else{
            return getinputParams();
        }
    }

    public static String [] getinputParams(){
        //Contract 
        //  @return     String array of user input
        //  @notes:     If no cmd input then get user input

        //Create input scanner
        Scanner input = new Scanner(System.in);
        String [] params = new String[3];

        //Get string param
        System.out.print("\tEnter a string to convert (String):\t");
        params[0] = input.nextLine();

        //Get initial base param
        System.out.print("\tEnter the initial base (Integer):\t");
        params[1] = input.nextLine();

        //Get target base param
        System.out.print("\tEnter the new target base (Integer):\t");
        params[2] = input.nextLine();

        //Close scanner object
        input.close();

        //return params
        return params;
    }

    public static int convertToInt(String input){
        //Contract
        //  @param  String input, user input integer value
        //  @return int, return string value as integer
        //  @notes  try/catch forany random errors then system exit

        int base = 0;
        
        try{
        
            base = Integer.parseInt(input);
            
        }catch(Exception ex){
            String msg = "\nThere has been an error with your input values.... " + 
                        "\nThe value '" + input.toString() + "' is not a correct integer base value" + 
                        "\n\tThe program will now close, Sorry!";
            
            //print error message
            System.out.println(msg);
            System.exit(0);
        }
        return base;
    }

    public static String formatInputString(String input){
        //Contract
        //  @params     input, input to convert
        //  @return     sformatted String value
        //  @notes      formatt the users input, remove junk & then uppercase all
            
        StringBuilder sb = new StringBuilder();
        
        String userStr = input.replaceAll("\\s+", "");
        
        char[] userInput = userStr.toCharArray();
        
        if(userStr.length() > 0){
            
            //Loop input string, get only digits and letters
            // convert letters to uppercase & remove any junk
            
            for(int i = 0; i < userStr.length(); ++i){ 
                
                if(Character.isLetter(userInput[i])){
                    sb.append(Character.toUpperCase(userInput[i]));
                    
                }else if(Character.isDigit(userInput[i])){
                    sb.append(userInput[i]);
                }
            }
                return sb.toString(); 
        }
        return ""; 
    }

    public static boolean isValidBase(String userString, int base){
        //Contract
        //  @params     userString, input to convert
        //  @params     base, base type of the input string
        //  @return     boolean predicate  
        //  @notes      Check the base type against the input string for validity
        
        char [] input = userString.toCharArray();
        int maxChar = 0;
        boolean isValid = false;

        for(int i = 0; i < input.length; i++){
            char ch = input[i];
            if(ch >= 'A' && ch <= 'Z'){
                // System.out.print(ch);   
                // System.out.print("->");
                // System.out.print((int)ch-54);
                maxChar = ((int)ch > maxChar)? (int)ch-54: maxChar;

            }else if(ch >= '0' && ch <= '9'){
                // System.out.print(ch);
                // System.out.print("->");
                // System.out.print((int)ch-47);
                maxChar = ((int)ch > maxChar)? (int)ch-47: maxChar;
            }
            // System.out.println(); 
        }

        isValid = maxChar <= base ? true : false;

        // System.out.print("isValid: ");
        // System.out.print(isValid);
        // System.out.print("  -maxChar: ");
        // System.out.print(maxChar);
        // System.out.print("  -base: ");
        // System.out.println(base);

        //test input string
        //0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ

        //return predicate for is valid
        return isValid;
    }

    public static String convertToBaseTen_BigInt(String input, int i_base, int t_base){
        //Contract
        //  @param  String input, user input value
        //  @param  int i_base, initial base value
        //  @return String, returns value as base ten(decimal) 

        BigInteger result_BigInt = BigInteger.ZERO;

        for(int i = 0; i < input.length(); i++){
            char numChar = input.charAt(i);
            int charToInt = charToInt(numChar);
            
            //System.out.println("result_BigInt = " + result_BigInt + " * " + i_Base + " + " + charToInt);
            result_BigInt = result_BigInt.multiply(BigInteger.valueOf(i_base));
            result_BigInt = result_BigInt.add(BigInteger.valueOf(charToInt));
        }
        //Convert to new target base
        String retVal = convertFromBaseTen_BigInt(result_BigInt,t_base);

        return retVal;
    }

    public static int charToInt(char ch){
       //Contract
        //  @param  char ch, convert ch to int eqivelent
        //  @return int, converted int value
        if(ch >= 'A' && ch <= 'F'){
            return 10 + ch - 'A';
        }else{
            return ch - '0';
        }
    }

    //Helper and Testing Functions
    public static String convertBases(String input, int i_base, int t_base){
        //Contract 
        //  @param  string input, users string input value to convert
        //  @param  int i_base, the initial base of the users value
        //  @param  int t_base, target base to convert to
        //  @return String convertBases, return value as string
        //  @notes  Used this function to test my calculated results against

        BigInteger converted = new BigInteger(input, i_base);
        return converted.toString(t_base);
    }

    public static void convertFromBaseTen_BigInt(String input, int t_base){
        //Contract
        //  @param  String input, user input value as base ten value
        //  @param  int t_base, target base value
        //  @return String, returns value desired base
        //  @reference  https://mathbits.com/MathBits/CompSci/Introduction/frombase10.htm

        StringBuilder result = "";
        BigInteger quotient = BigInteger.ZERO;
        BigInteger remainder = BigInteger.ZERO;
        BigInteger input_BigInt = BigInteger.valueOf(input);

        //TODO: Need to fix loop and check the function performance
       for(input_BigInt;){

            System.out.printf("input: %s ", input);
            quotient = input_BigInt.divide(BigInteger.valueOf(t_base));
            remainder  = quotient.mod( BigInteger.valueOf(t_base));

            System.out.printf("quotient: %s remainder %s", quotient, remainder);

            input_BigInt = quotient;
            result.add(input_BigInt.toString());

        }
        System.out.println(result.toString());
        //return result.toString();
    }

    public static void printArray(String[] arr){
        //Contract
        //  @param  string array
        //  @return void
        //  @notes  helper function to test print single dim array values

        System.out.println("User Parameters:");
        for (String i : arr) {
            System.out.println(i);
        }
    }
    
    public static int convertToBaseTen_Int(String num, int initial){
        int decVal = 0;
     
        for(int i = 0; i < num.length(); i++){
            char numChar = num.charAt(i);

            decVal = decVal * initial + charToInt(numChar);  

        }
        return decVal;
    }

}