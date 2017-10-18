/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 48
 * Due: xx/xx/xxxx
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Hunt_W8_Classes {
    public static void main(String[] args) {
        System.out.println("\n~~~~~~~~~~~~ Abstract classes and Interfaces Program - Advanced Java Week 8 ~~~~~~~~~~~~\n");

        String fileName = "";
        if (args.length == 1) {
            fileName = args[0];
        } else if (args.length == 0) {
            System.out.print("Please enter the file path: ");
            // Scanner sc = new Scanner(System.in);
            // fileName = sc.nextLine();
        } else {
            System.out.println("There was a problem processing your file");
            System.exit(0);
        }

    }
}