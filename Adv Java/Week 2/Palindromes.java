/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Assignment 2
 * Due: 9/10/17
 */

import java.util.Scanner;
import java.lang.Character;

public class Palindromes {
    public static void main(String[] args) {
        String input = "";
        
         if(args.length > 0){                           //Get user input from console
             for(String s : args){
                 input += s;
             }
            System.out.println("Input palindrome : " + input);
        }
        else{                                          //Get user input
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter a palindrome to test: ");
            input = in.nextLine();
        }
         
        //Test conditions and return result
        boolean isOrdinary = isOrdinaryPal(input);
        boolean isStrict = isStrictPal(input);
        
        //Test results of tested conditions 
        if(input.equals("")){
            System.out.println("\nYou have to actually put a value in to test it.");
           
        }else if(isStrict && isOrdinary){
            System.out.println("The input \"" + input + "\" is in Strict format.");
           
        }else if(isOrdinary){
            System.out.println("The input \"" + input + "\" is in Ordinary format.");
           
        }else{
            System.out.println("The input \"" + input + "\" is in not a palindrome.");
        }   
    }
    
    public static boolean isOrdinaryPal(String input){  
        //Remove junk with regex 
            //Reference; https://www.tutorialspoint.com/java/java_regular_expressions.htm
            
        String in = input.replaceAll("\\P{Alnum}", "").toUpperCase();
            //System.out.println("Ordinary palindrome: "+in);
            
        //if length is 1 or 0
        if(in.length() < 2){
            return true;
        }else{            
            //System.out.println(in.substring(1,in.length()-1));

            //if char 0 == the last char
            if(in.charAt(0) == in.charAt(in.length()-1)){
                return isOrdinaryPal(in.substring(1,in.length()-1));
            }else{
                return false;
            }
        }
    }
    
    public static boolean isStrictPal(String input){
       //Remove junk with regex
            //Reference; https://www.tutorialspoint.com/java/java_regular_expressions.htm
       
       String in = input.replaceAll("[^A-Za-z0-9\\s]", "").toUpperCase();
            //System.out.println("Strinct palindrome: "+in);
       
       //if length is 1 or 0
       if(in.equals(" ") || in.length() < 2){
           return true;
       }else{
           //System.out.println(in.substring(1,in.length()-1));
           
           //if char 0 == the last char
           if(in.charAt(0) == in.charAt(in.length()-1)){
               return isStrictPal(in.substring(1,in.length()-1));
           }else{
               return false;
           }
        }
     
    } 
}
