/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 6
 * Due: 10/1/2107
 * Hunt_W6_Classes
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class array_demo{
    public static void main(String [] args){
        // Example 1
        // int a [] = new int[10];
        // Scanner s = new Scanner(System.in);
        // int i, v;

        // while(true){
        //     System.out.print("Please enter index: ");
        //         i = s.nextInt();
        //     System.out.print("Please enter value: ");
        //         v= s.nextInt();
        //     try{
        //         int out = a[i] = v;
        //         System.out.println("You added a value of " + v + " at the index of " +i);
        //     }catch(ArrayIndexOutOfBoundsException e){
        //         System.out.println("\tOOPS you had an error!");
        //         System.out.println("\t"+e.toString());
        //     }
        // }//eoWhile

        //Example 2 - file open exception
        String fileName;
        Scanner s = new Scanner(System.in);
        Scanner sf;
        while(true){
            System.out.print("\n");
            System.out.print("Please enter a file name: ");
            fileName = s.nextLine();
            System.out.print("Attempting to open file: " + fileName + "...");

            try{
                sf = new Scanner(new File(fileName));
                System.out.print("File " + fileName + "is open");

            }catch(FileNotFoundException fe){
                 System.out.println("File " + fileName + "is not found");
                 System.out.println("\tOOPS you had a file error!");
                 System.out.println("\t" + fe.toString());
            }
        }

    }//eo main
}