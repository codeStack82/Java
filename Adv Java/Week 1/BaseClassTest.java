/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Spring 2017
 * Assignment 1 
 * Due: 08/22/17
 */

import java.math.BigInteger;
import java.util.Scanner;
import java.util.InputMismatchException;

public class BaseClassTest {
    public static void main(String[] args) {
        //Declarations
        String userString = "";
        int initialBase = 0;
        int desiredBase= 0;
            
        //check where input is coming from 
        if(args.length > 0){
            if(args.length == 3){
                
                //display intro message
                introMsg();
                
                //Prompt to get user string
                userString = validate_InputFormat(args[0]);
                
                //Prompt to get initial Base 
                initialBase = get_Base(args[1]);

                //Prompt to get desired Base
                desiredBase = get_Base(args[2]);

                Boolean isValid = allInputValid(userString, initialBase, desiredBase);


                if(isValid){
                    String input = validate_InputFormat(userString); 

                    println("Intput: "+input);

                    String output = convertInput(input, initialBase, desiredBase);

                    println("Output: "+output + "\n");

                }else{
                    errorMsg();
                }
                
            }else{
                errorMsg();
            }
        }else{
            //Else case: If no input was added to cmd
            
            //display intro message
            introMsg();
            
            //print directions
            println("Please, enter a String, a Base (integer), "
                    + "and a base conversion (integer).\n");

            //Prompt to get user string
            userString = get_UserString(); 
            
            //Prompt to get initial Base 
            initialBase = get_InitialBase();

            //Prompt to get desired Base
            desiredBase = get_DesiredBase();

            Boolean isValid = allInputValid(userString, initialBase, desiredBase);
           
            
            if(isValid){
                String input = validate_InputFormat(userString); 
              
                println("Intput: "+input);

                String output = convertInput(input, initialBase, desiredBase);
                
                println("Output: "+output+ "\n");
                
            }else{
                errorMsg();
            }
        }    
    }
    
    //Display intro message
    public static void introMsg(){
        //Contract: Display intro message
        //get username if applicable
        String user = System.getProperty("user.name");
  
        //get username if applicable
        String userMsg = (!user.isEmpty())? "Hello, " + user 
                    + "\n": "Hello,\n";
        //print 
        println(userMsg);
    }
    
    //Display general error message
    public static void errorMsg(){
        //Contract: display error general message and exit
        //print directions
        String msg = "\nThere has been an error. " + 
                     "\n\tThe program will now close";
        
        //print all
        println(msg);
        
        System.exit(0);
    }
    
    //Display general error message
    public static void errorIncorrectCase(){
        //Contract: display error general message and exit
        //print directions
        String msg = "\nThere has been an error....\n" + 
                     "\tThe base case you entered is not computable.\n" +
                     "\tThe program will now terminate!!!";
        
        //print all
        println(msg);
        
        System.exit(0);
    }
     
    
    //Get users inputs data~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static String get_UserString(){
        //contract: get user input string
        
        //create input scanner
        Scanner input = new Scanner(System.in);
        
        //display message to user
        String message = "Please enter a string: ";
        System.out.print(message);
        
        //get user input
        String userString = input.nextLine();
        
        return userString;
    }
    
    public static int get_InitialBase(){
    //Contract: get user input string
    
        //create input scanner
        Scanner input = new Scanner(System.in);
        
        int base = 0;
        
        try{
            //display message to user
            String message = "Please enter an initial base (integer) between 2 and 36: ";
            System.out.print(message);

            //get user input
            base = input.nextInt();
            
        }catch(InputMismatchException ex){
            errorMsg();
        }
        return base;
    }
    
    public static int get_DesiredBase(){
        //Contract: get user input string
    
        //create input scanner
        Scanner input = new Scanner(System.in);
        
        int base = 0;
        
        try{
            //display message to user
            String message = "Please enter an desired base (integer) between 2 and 36: ";
            System.out.print(message);

            //get user input
            base = input.nextInt();
            
        }catch(InputMismatchException ex){
            errorMsg();
        }
        return base;
    }
    
    public static int get_Base(String input){
    //Contract: process cmd input
        int base = 0;
        
        try{
           
            //get user input
            base = Integer.parseInt(input);
            
        }catch(InputMismatchException ex){
            errorMsg();
        }
        return base;
    }

    //Validate input data~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static String validate_InputFormat(String input){
          
        StringBuilder sb = new StringBuilder();
        
        String userStr = input.replaceAll("\\s+", "");
        
        char[] userInput = userStr.toCharArray();
        
        if(userStr.length() > 0){
            
            //Loop input string, get only digits and letters
                //convert letters to uppercase & remove any junk
            
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
    
    public static Boolean validate_UserString(String userString, int base){
    //Contract: if input string is valid return valid
    
        Boolean isValid = false;                                //bool flag
        
        String userStr = validate_InputFormat(userString);      //validate only letter or digit
        
        Integer num = userStr.length();                         //get str length
        
        char[] userInput = userStr.toCharArray();               //convert to char array
        
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
    
    public static Boolean validate_InitialBase(int base){
        Boolean isValid = false;
   
            if(base >= 2 && base <= 36){
                isValid = true;
            }else{
                errorMsg();
            }
        return isValid;
    }
    
    public static Boolean validate_DesiredBase(int base){
        Boolean isValid = false;
   
            if(base >= 2 && base <= 36){
                isValid = true;
            }else{
                errorMsg();
            }
        return isValid;
    }
    
    public static Boolean allInputValid(String input, int initialNum, int desiredNum){
        Boolean isValid = false;
        
        Boolean userString = validate_UserString(input,initialNum);
        Boolean initialBase = validate_InitialBase(initialNum);
        Boolean desiredBase = validate_DesiredBase(desiredNum);
        
        isValid = (userString && initialBase && desiredBase)? true : false;
        
        return isValid;
    }
    
    
    //Conversions TODO: Conversions ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static String convertBase(String input, int initialBase, int desiredBase){
        
        StringBuilder sb1, sb2;
        sb1 = new StringBuilder();
        
        Integer num = input.length();                           //get str length
        
        char[] userInput = input.toCharArray();               //convert to char array
        
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
                     if( check == SYMBOLS[j]){
                         sb1.append(j);
                     }
                }
            } 
//            
//           String numConvert = sb1.toString();
//           String dBase = desiredBase;
//           BigInteger bi1, bi2, bi3;
//           
//           bi1 = new BigInteger(numConvert);
//           bi2 = new BigInteger();
//           
//           for(int k = 0; k < numConvert.length(); ++k){
//               bi3 = bi1.divideAndRemainder(bi2);
//           }
           
        
        return sb1.toString();
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
   
    //println~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void println(String s){
        System.out.println(s);
    }
    
}
