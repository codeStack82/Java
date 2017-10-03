import java.util.Scanner;
import sun.net.RegisteredDomain;

/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 6
 * Due: 10/1/2107
 * Hunt_W6_Classes
*/

public class Hunt_W6_Classes{
    public static void main(String [] aarrgs){
        System.out.println("\n~~~~~~~~~~~~ Class Builder Program - Advanced Java Week 6 ~~~~~~~~~~~~\n");
        System.out.println("\n//Examples Section~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
        
        System.out.println("\n//Person 1 Info");
        Person p1 = new Person("Donald", "Trump");
            System.out.println(p1.toString());
            System.out.println("\tPrint first: " + p1.getFirstName());
            System.out.println("\tPrint last: " + p1.getLastName());
            System.out.println();

            //Actions
            System.out.println("//Person 1 Actions");
            p1.eat();
            p1.sleep();
            p1.play();
            p1.run();
            System.out.println();

        System.out.println("//Person 2 Info");
        OCCCDate dob = new OCCCDate(1,2,1998);
        Person p2 = new Person("Zabrina", "Antry", dob);
            //Names
            System.out.println(p2.toString());
            System.out.println("\tPrint first: " + p2.getFirstName());
            System.out.println("\tPrint last: " + p2.getLastName());
            System.out.println();

             System.out.println("//Person 2 Dates with formatting");
            System.out.println("\tPrint DOB (US): " + p2.getDOB());
                dob.setStyleFormat(false);
            System.out.println("\tPrint DOB (US): " + p2.getDOB());
                dob.setStyleFormat(true);
                dob.setDateFormat(false);
            System.out.println("\tPrint DOB (EURO): " + p2.getDOB());
                dob.setStyleFormat(false);  
            System.out.println("\tPrint DOB (EURO): " + p2.getDOB());
            System.out.println();

            System.out.println("//Person 2 Actions");
            p2.eat();
            p2.sleep();
            p2.play();
            p2.run();
            System.out.println();

            //Equals
            System.out.println("//People Comparrisons: Person 1 and Person 2 .equals()");
            System.out.println("\tCompare person 1 and person 2: "+ p1.equals(p2));
            System.out.println("\tCompare person 1 and person 1: "+ p1.equals(p1));
            System.out.println();
            
        System.out.println("//Registered Person 1 Info");    
        RegisteredPerson rP1 = new RegisteredPerson("Tyler", "Hunt", "778547");
            //Names
            System.out.println("Print toString: " + rP1.toString());
            System.out.println("\tPrint first: " + rP1.getFirstName());
            System.out.println("\tPrint last: " + rP1.getLastName());
            System.out.println();

            //Actions
            System.out.println("//Registered Person 1 Actions");  
            rP1.eat();
            rP1.sleep();
            rP1.play();
            rP1.run();
            System.out.println();

        System.out.println("//Registered Person 2 Info");  
        RegisteredPerson rP2 = new RegisteredPerson("Thomas", "O\'Connell", "778549");
            //Names
            System.out.println(rP2.toString());
            System.out.println("\tPrint first: " + rP2.getFirstName());
            System.out.println("\tPrint last: " + rP2.getLastName());
            System.out.println();

            //Actions
            System.out.println("//Registered Person 2 Actions");  
            rP2.eat();
            rP2.sleep();
            rP2.play();
            rP2.run();
            System.out.println();

            //Equals
            System.out.println("//Registered People Comparrisons: Person 1 and Person 2 .equals()");
            System.out.println("\tCompare reg. person 1 and reg. person 2: "+ rP1.equals(rP2));
            System.out.println("\tCompare reg. person 2 and reg. person 2: "+ rP2.equals(rP2));
            System.out.println();


            System.out.println("//Register Person 2 and as Registered Person 3 Info");  //with person object
            RegisteredPerson rP3 = new RegisteredPerson(p2, "778551");
            //Names
            System.out.println(rP3.toString());
            System.out.println("\tPrint first: " + rP3.getFirstName());
            System.out.println("\tPrint last: " + rP3.getLastName());
            System.out.println();

            //Actions
            System.out.println("//Registered Person 2 Actions"); 
            rP3.eat();
            rP3.sleep();
            rP3.play();
            rP3.run();
            System.out.println();

            //Equals
            System.out.println("//Registered People Comparrisons: Person 1 and Person 2 .equals()");
            System.out.println("\tCompare person 2 and Registered person 3: "+ rP1.equals(rP3));
            System.out.println();

            System.out.println("//OCCCDate comparrisons");
            OCCCDate d1 = new OCCCDate(3,7,2011);
            OCCCDate d2 = new OCCCDate(3,5,2011);
            //Dates
            System.out.println("\tPrint date (US): " + d1.toString());
                d1.setStyleFormat(false);
            System.out.println("\tPrint date (US): " + d1.toString());
                d1.setStyleFormat(true);
                d1.setDateFormat(false);
            System.out.println("\tPrint date (EURO): " + d1.toString());
                d1.setStyleFormat(false);  
            System.out.println("\tPrint date (EURO): " + d1.toString());
            System.out.println();
            
            //Equals
            System.out.println("\tCompare date 1 and date: 2 "+ d1.equals(d2));
            System.out.println("\tCompare date 2 and date: 2 "+ d2.equals(d2));
            System.out.println();

            System.out.println("/Testing Section~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
           try{
                Scanner fname = new Scanner(System.in);
                System.out.print("\nPlease Enter a first name: ");
                String first = fname.next();

                Scanner lname = new Scanner(System.in);
                System.out.print("\nPlease Enter a last name: ");
                String last = lname.next();

                Person p3 = new Person(first, last);
                System.out.println("\nWelcome, " + first + " " + last + " to the Class homework assignment");

                Scanner date_OB = new Scanner(System.in);
                System.out.println("\nPlease enter your date of Birth Information");
                System.out.print("\tDay of the month: ");
                int day_OB = date_OB.nextInt();

                System.out.print("\tMonth of the year: ");
                int month_OB = date_OB.nextInt();

                System.out.print("\tFinally, the year: ");
                int year_OB = date_OB.nextInt();

                OCCCDate yourDOB = new OCCCDate(day_OB,month_OB,year_OB);

                Person p4 = new Person(first, last, yourDOB);
                System.out.println("\n"+first + " " + last + " your birthday is on " + yourDOB.toString() + " !!");

                System.out.println("\nI will now enroll you in a not to shady governemnt program!");

                RegisteredPerson p5 = new RegisteredPerson(p4,"34xx890x768");
                System.out.println("\tCongrats, " + first +" "+ last+ " you are now enrolled in a not to shady governemnt program!");
                System.out.println("\nHere is your official government information");
                System.out.println("\t"+p5.toString());   
           }catch(Exception e){
                System.out.println("Apparently, there has been some kind of error:");
                System.out.println(e.toString());
                System.out.println(e.getStackTrace());

           }            
    }
}