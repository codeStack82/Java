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
 * Hunt_W7_Exceptions part 1
 * */

 public class Hunt_W7_Exceptions_p1{
      public static String another = "";
      public static boolean more = false;
     public static void main(String[] args){
        System.out.println("\n~~~~~~~~~~~~ OCCC Date Exception Program  1 - Advanced Java Week 7 ~~~~~~~~~~~~\n");
        
        //Create and Print test Objects
        try{    

            //Create test dates
            ArrayList<OCCCDate> dates = new ArrayList<OCCCDate>();
                dates.add(new OCCCDate(20, 9, 1982));
                dates.add(new OCCCDate(22, 5, 2003));

            //Create test people
            ArrayList<OCCCPerson> people = new ArrayList<OCCCPerson>();
                people.add(new OCCCPerson("Tyler", "Hunt", dates.get(0)));
                people.add(new OCCCPerson("Bradley", "Hunt", dates.get(1)));

                //print all test objects
                for (int i = 0; i < people.size(); i++){
                    printAll(people.get(i),dates.get(i));
                }
                
            }catch(InvalidOCCCDateException ex){
                System.out.println("Error: Invalid-OCCCDate Exception");
                System.out.println("\t"+ex.getStackTrace());
                System.out.println("\t"+ex.toString());
            }

            //Give user the option to test Person and Date object creation
            System.out.print("Would you like to create a new person object? (y or n) ");
            Scanner in = new Scanner(System.in);   
            another = in.next(); 
            if(another.compareToIgnoreCase("y")==0){   
                do{
                    //Try create person and datte objects
                    try{
                            //Get Person and Date information
                            System.out.println("Enter first and last names ");
                                System.out.print("\tFirst name: ");
                                    String fName = in.next();
                                System.out.print("\tLast name: ");
                                    String lName = in.next();
                            System.out.println("Enter a date of birth: ");
                                System.out.print("\tEnter a year: ");
                                    int year = in.nextInt();
                                System.out.print("\tEnter a month: ");
                                    int month = in.nextInt();
                                System.out.print("\tEnter a day: ");
                                    int day = in.nextInt();
            
                            //Create Date and Person then printAll
                            OCCCDate   d = new OCCCDate(day, month, year);
                            OCCCPerson p = new OCCCPerson(fName, lName, d);
                            printAll(p, d);
                        
                    }catch(InvalidOCCCDateException ex){
                        System.out.println("Error: Invalid-OCCCDate Exception");
                        System.out.println("\t"+ex.getStackTrace());
                        System.out.println("\t"+ex.toString());

                    }catch(InputMismatchException ex){
                        System.out.println("Error: Input-Mismatch Exception");
                        System.out.println("\t" + ex.getStackTrace());
                        System.out.println("\t" + ex.toString());

                    }catch(Exception ex){
                        System.out.println("Error: General Exception");
                        System.out.println("\t" + ex.getStackTrace());
                        System.out.println("\t" + ex.toString());

                    }finally{
                        //Clean up 
                        System.out.print("\nWould you like to create another person object? (y or n) ");
                        another = in.next();
                        more = another.compareToIgnoreCase("y")==0? true: false;
                    }
                }while(more);
            }
        System.out.println("\tEnd of the Try/Catch Exception Program. Thanks");
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

 
