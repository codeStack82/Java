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
     public static void main(String[] args){
         System.out.println("\n~~~~~~~~~~~~ OCCC Date Exception Program  2 - Advanced Java Week 7 ~~~~~~~~~~~~\n");

        String fileName = "";
        if (args.length == 1) {
            fileName = args[0];
        } else if (args.length == 0) {
            System.out.print("Please enter the file path: ");
            Scanner sc = new Scanner(System.in);
            fileName = sc.nextLine();
        } else {
            System.out.println("There was a problem processing your file");
            System.exit(0);
        }

        System.out.println("Attempting to open file " + fileName + "...");
        System.out.println();

     }
 }
