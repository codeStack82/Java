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
import java.util.Scanner;
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
                System.out.println("\nMy function values");
                String str = convertBases(userStr, initial_Base, target_Base);
                System.out.println("\tInitial base ->\t" + initial_Base + ":\t " + userStr);
                System.out.println("\tTarget base  ->\t" + target_Base + ":\t " + str);       
            }else{
                System.out.println("\nThe user input string '" + userStr + "' is not of base type " + initial_Base);
                System.out.println("\tSorry, Please try again some other time!");
            }
        }catch(Exception ex){
            System.out.println("Apparently, there has been some sort of weird/random anolomy is this program????");
            System.out.println("\tThe program will now exit, Sorry!");
            System.exit(1);
        }
    }//eoMain

    public static void introMessage(){
        //Contract 
        //  Print intro message
        //  @return -> void, no output 
        System.out.println("\n~~~~~~~~~~~~ Base Conversion Program - Advanced Java Week 1 ~~~~~~~~~~~~\n");
        System.out.println("This Program converts a string input from it's initial base to a different target base.\n");
        System.out.println("Please, enter a string, an initial base (integer), and a target base (integer) for conversion.");
    }

    public static boolean isCmdLine(String [] args){
        //Contract 
        //  @notes:     Check to see if user started progam with cmd inputs
        //  @param      args[], cmd line input array 
        //  @param      isCmd, check if input > 0 and == 3
        //  @return     boolean, predicate
        //  @Tested     8/24/17

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
            return getinputParams();
        }
    }

    public static String [] getinputParams(){
        //Contract 
        //  @notes:     If no cmd input then get user input
        //  @return     String array of user input
        //  @Tested     8/25/17

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

        //Close scanner object
        input.close();

        //return params
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
                        "\nThe value '" + input.toString() + "' is not a correct integer base value" + 
                        "\n\tThe program will now close, Sorry!";
            
            //print
            System.out.println(msg);
            
            System.exit(0);
        }
        return base;
    }

    public static String formatInputString(String input){
        //Contract
        //  @notes      formatt the users input, remove junk & then uppercase all
        //  @params     input, input to convert
        //  @return     sformatted String value
            
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
        //  @notes      Check the base type against the input string for validity
        //  @params     userString, input to convert
        //  @params     base, base type of the input string
        //  @return     boolean predicate  
        
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

    public static String convertBases(String input, int i_base, int t_base){
        BigInteger converted = new BigInteger(input, i_base);
        return converted.toString(t_base);
    }

    public static void printArray(String[] arr){
        //Contract
        //  @notes  helper function to test print single dim array values
        System.out.println("User Parameters:");
        for (String i : arr) {
            System.out.println(i);
        }
    }

    //Test functions
    public static String convertInput(String input, Integer initialBase, Integer desiredBase){
        //Contract: Take string, initial base, desired base and convert; 
        //          utilize BigInt then return string
        //          Conversion resource info here: 
        //              https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html
        //              http://www.kaagaard.dk/service/convert.htm
        //              http://www-rohan.sdsu.edu/~pwbrock/files/UNIT4.3.pdf
        
        String output = "";

        // checks if initial base and out are same if so then return input
        //output = (initialBase==desiredBase)? input: "";
            
        BigInteger Bi = new BigInteger(input,initialBase);
        
        output = Bi.toString(desiredBase);
        
        return output;
    }
    
    public static int convertBaseTen(String num, int initial){
        int decVal = 0;
        BigInteger b1 = new BigInteger("0");
        BigInteger b2 = new BigInteger("0");

        for(int i = 0; i < num.length(); i++){
            char numChar = num.charAt(i);

            int x = initial + charToInt(numChar);
            String str_initial_BasePlusCharToInt = Integer.toString(x);
            String str_DecVal = Integer.toString(decVal);

            BigInteger initialPlusCharToInt = new BigInteger(str_initial_BasePlusCharToInt);
            BigInteger decValue = new BigInteger(str_DecVal);

            b1 = decValue.multiply(initialPlusCharToInt);

            //decVal = decVal * initial + charToInt(numChar);  


            //System.out.printf("decVal: %d - initial: %d - charToInt:%d\n",decVal,initial,charToInt(numChar));
        }
        System.out.print(b1.toString());
        return decVal;
    }
    public static int charToInt(char ch){
        if(ch >= 'A' && ch <= 'F'){
            return 10 + ch - 'A';
        }else{
            return ch - '0';
        }
    }

}