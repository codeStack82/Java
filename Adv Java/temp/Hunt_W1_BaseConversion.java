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
        String userStr = "";
        int initial_Base = 0;
        int target_Base = 0;


        //Display intro message
        introMessage();

        //Get params 
        String[] params = getParams(args);

        //Set params
        userStr = params[0].toString();
        initial_Base = convertToInt(params[1].toString());
        target_Base = convertToInt(params[2].toString());

        //Validate inputs
        userStr = validate_InputString(userStr);
        //System.out.printf("%s - %d - %d\n",userStr,initial_Base,target_Base);


        boolean is_ValidBase = isValidBase(userStr, initial_Base);
        //System.out.println(is_ValidBase);

        if(is_ValidBase){
            //Actual
            String str = convertInput(userStr, initial_Base, target_Base);
            System.out.println("Initial base ->\t" + initial_Base+ ":\t " + userStr);
            System.out.println("Target base  ->\t" + target_Base + ":\t " + str);
        }  
    }//eoMain

    public static void introMessage(){
        //Contract 
        //  Print intro message 
        System.out.println("\n~~~~~~~~~~~~ Base Conversion Program - Advanced Java Week 1 ~~~~~~~~~~~~\n");
        System.out.println("This Program converts a string input from it's initial base to a different target base.\n");
        System.out.println("Please, enter a string, an initial base (integer), and a target base (integer) for conversion.");
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
    
    
    public static String validate_InputString(String input){
          
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
    
    public static Boolean isValidBase(String userString, int base){
    //Contract: if input string is valid return valid
    
        Boolean isValid = false;                                //bool flag
        
        char[] userInput = userString.toCharArray();               //convert to char array
        
        //Create sybmol array
        char[] SYMBOLS = {'0','1','2','3','4','5','6','7','8','9','A','B'
                        ,'C','D','E','F','G','H','I','J','K'
                        ,'L','M','N','O','P','Q','R','S','T'
                        ,'U','V','W','X','Y','Z'}; 
        
            //loop to check base case str and check validity
            for(int i = 0; i < userInput.length; ++i){
                char check = userInput[i];
                
                //loop to check if initial base valid
                for(int j=0; j < SYMBOLS.length; ++j){
                    //Check if input is in correct base
                     if( check == SYMBOLS[j] && j <= base){
                         isValid = true;
                     }else if(check == SYMBOLS[j] && j > base){
                         isValid = false;
                     }
                }
            } 
        return isValid;
    }

    public static String convertInput(String input, Integer initialBase, Integer desiredBase){
        //Contract: Take string, initial base, desired base and convert; 
        //          utilize BigInt then return string
        //          Conversion resource info here: 
        //              https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html
        //              http://www.kaagaard.dk/service/convert.htm
        //              http://www-rohan.sdsu.edu/~pwbrock/files/UNIT4.3.pdf
        
        String output = "";
            
        BigInteger Bi = new BigInteger(input,initialBase);
        
        output = Bi.toString(desiredBase);
        
        return output;
    }

    public static void printArray(String[] arr){
        System.out.println("User Parameters:");
        for (String i : arr) {
            System.out.println(i);
        }
    }

}