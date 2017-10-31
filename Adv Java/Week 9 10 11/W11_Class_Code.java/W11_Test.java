/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 11
 * Test Class
*/

import java.io.*;
import java.util.Scanner;


public class W11_Test{
    public static void main(String[] args){

        Person[] p = new Person[2];

        p[0] =  new Person("Tyler", "Hunt");
        p[1] =  new RegisteredPerson(p[0],"re356");


        for(int i = 0; i < p.length; i++){
            System.out.println(p[i].toString());
        }

        String fileName = "";
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter file name (test.dat or .txt): ");
        fileName = s.nextLine();

        // Write objecct to disk or a file just like youd print to the console using serializable
        try{ 
            FileOutputStream fout =  new FileOutputStream(fileName);
            ObjectOutputStream oout = new ObjectOutputStream(fout);
             for(int i =0; i < p.length; i++){
                oout.writeObject(p[i]);
            }
            //filetype is .dat <-serializable
            System.out.println("Files have been written to a file.");
        }catch(IOException e){
            System.out.println(e.toString());
        }

        //Read in objects from serializable .dat file into super array
        Person[] q =  new Person[p.length];

        try{
            FileInputStream fin =  new FileInputStream(fileName);
            ObjectInputStream oin = new ObjectInputStream(fin);
            Object o;

            for(int i = 0; i < q.length; i++){
                o = oin.readObject();
                
                if(o.getClass().equals(Person.class)){
                    q[i] = (Person) o;              //TypeCast to the correct type form the object
                }else if(o.getClass().equals(RegisteredPerson.class)){
                    q[i] = (RegisteredPerson) o;    //TypeCast to the correct type form the object
                }else{
                    System.out.println("Oh No bad stuff happend...");
                }

            }

            System.out.println("Print read in objects");
            for(int i =0; i < q.length; i++){
                System.out.println(q[i].toString());
             }

        }catch(IOException e){
            System.out.println(e.toString());
        }

    }//eoMain
}