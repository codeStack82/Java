import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 7
 * Due: 10/17/2107
 * Hunt_W7_Exceptions part 2
 * */

 public class Hunt_W7_Exceptions_p2{
      public static String another = "";
      public static boolean more = false;
     public static void main(String[] args){
        System.out.println("\n~~~~~~~~~~~~ OCCC Date Exception Program  2 - Advanced Java Week 7 ~~~~~~~~~~~~\n");

            //Create test people
            System.out.println("Print two valid person and date objects");
            OCCCPerson p1   = new OCCCPerson("Tyler", "Hunt", new OCCCDate(20, 9, 1982));
            printAll(p1, p1.getDOB());
            OCCCPerson p2   = new OCCCPerson("Maile", "McKowen", new OCCCDate(29, 2, 2012));
            printAll(p1, p2.getDOB());
            
            System.out.println("Attempt to create and print valid person and date object");
            OCCCPerson p3   = new OCCCPerson("Avery", "McKowen", new OCCCDate(29, 2, 2013));
            printAll(p1, p3.getDOB());
                
            //Should never print this....    
            System.out.println("Program should have crashed by now......");
     }

     public static void printAll(OCCCPerson p, OCCCDate d){
            System.out.println(p.toString() + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("\tDay:\t\t\t" + d.getDayOfMonth());
                System.out.println("\tMonth:\t\t\t" + d.getMonth());
                System.out.println("\tYear:\t\t\t" + d.getYear());
                System.out.println("\tDay of Week:\t\t" + d.getDayOfWeek());
                System.out.println("\tName of Month:\t\t" + d.getNameOfMonth());
                System.out.println("\tAge:\t\t\t" + d.getDifferenceInYears());
                System.out.println("\tAge w/object:\t\t" + d.getDifferenceInYears(d));
                System.out.println("\tPerson Dob:\t\t" + p.getDOB());
                System.out.println("\tDob==(now):\t\t" + d.equals(new GregorianCalendar(2017, 2, 29)));
                System.out.println("\tIs leap year:\t\t" + d.isLeapYear());
                System.out.println("\tDate (US):\t\t" + d.toString());
                d.setStyleFormat(false);
                System.out.println("\tDate (US):\t\t" + d.toString());
                d.setStyleFormat(true);
                d.setDateFormat(false);
                System.out.println("\tDate (EURO):\t\t" + d.toString());
                d.setStyleFormat(false);  
                System.out.println("\tDate (EURO):\t\t" + d.toString());
                System.out.println();
                
     }
 }

 
