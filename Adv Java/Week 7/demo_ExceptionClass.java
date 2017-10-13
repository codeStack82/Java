/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 6
 * Due: 10/1/2107
 * Hunt_W6_Classes
*/
import java.util.Scanner;

//Test class for OCCCDate Exception

public class demo_ExceptionClass{
    public static void main(String [] args){

        try{
            throwException();

        }catch(invalidOCCCDateException e){
            System.out.println(e.toString());
        }
       
    }

    public static void throwException(){
    throw new invalidOCCCDateException("OHH NOOOOO");
}
}
