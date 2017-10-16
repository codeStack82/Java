import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 7
 * Due: 10/17/2107
 * Hunt_W7_Exceptions part 1
 * */

 public class Hunt_W7_Exceptions_p1{
     public static void main(String[] args){
         System.out.println("\n~~~~~~~~~~~~ OCCC Date Exception Program  1 - Advanced Java Week 7 ~~~~~~~~~~~~\n");

        String fileName = "";
        if (args.length == 1) {
            fileName = args[0];
        } else if (args.length == 0) {
            // System.out.print("Please enter the file path: ");
            // Scanner sc = new Scanner(System.in);
            // fileName = sc.nextLine();
        } else {
            System.out.println("There was a problem processing your file");
            System.exit(0);
        }

        try{
            //Test dates
            OCCCDate d3 = new OCCCDate(31, 11, 2006);
            // OCCCDate d3 = new OCCCDate(31, 2, 2016); 
            // OCCCDate d3 = new OCCCDate(29, 2, 2020);           
            // OCCCDate d3 = new OCCCDate(20, 9, 1982);    
            // OCCCDate d3 = new OCCCDate(29, 2, 2016);     
            // OCCCDate d4 = new OCCCDate(14, 10, 2017);
            // OCCCDate d5 = new OCCCDate(d2);
            // OCCCDate d6 = new OCCCDate(d3);

            Person person1 = new Person("Tyler", "Hunt", d3);
            System.out.println(person1.toString());
            System.out.println("\tDay:\t\t" + d3.getDayOfMonth());
            System.out.println("\tMonth:\t\t" + d3.getMonth());
            System.out.println("\tyear:\t\t" + d3.getYear());
            System.out.println("\tDay of Week: \t" + d3.getDayOfWeek());
            System.out.println("\tName of Month: \t" + d3.getNameOfMonth());
            System.out.println("\tAge:\t\t" + d3.getDifferenceInYears());
            System.out.println("\tAge:\t\t" + d3.getDifferenceInYears(d3));
            System.out.println("\tdob:\t\t" + person1.getDOB());
            System.out.println("\tdob==(now):\t" + d3.equals(new GregorianCalendar(2017, 2, 29)));

        }catch(invalidOCCCDateException d){
            System.out.println("Error in main: The date you added is incorrect!");
        }
        
        // OCCCDate d = new OCCCDate(14, 10, 2017);
        // OCCCDate d = new OCCCDate(29, 2, 2015);  
        // OCCCDate d = new OCCCDate(29, 2, 2016);  
        // Person person2= new Person("Brad", "Hunt", d);
        // System.out.println(person2.getDOB());

   

        System.out.println("Test");

     }
 }
