/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 6
 * Due: 10/1/2107
 * Person Class
*/


import java.util.Date;

public class Person{

    private String firstName;
    private String lastName;
    private OCCCDate dob;
        
    //Constructors
    public Person(String firstName, String lastName){
        this.firstName  = new String(firstName);
        this.lastName   = new String(lastName);
    }

    // Date OCCCDate
    public Person(String firstName, String lastName, OCCCDate dob){
        this.firstName  = new String(firstName);
        this.lastName   = new String(lastName);
        this.dob        = dob;
    }

    public Person(Person P){}  //Copy constructor

    //Getters
    public String getFirstName(){
        return new String(firstName);
    }
      
    public String getLastName(){
        return new String(lastName);
    }

    public OCCCDate getDOB(){
        return dob;
        //might have to check null?
    }

    public int getAge(){
        int age = 0;
        if(this.dob != null){
            dob.getDifferenceInYears();
        }

     return age;   
    }

    //Setters
    public void setFirstName(String firstName){
         this.firstName = firstName;
    }

    public void setLastName(String lastName){
         this.lastName = lastName;
    }

    public void eat(){
        System.out.println("\tA " + getClass().getName() + " named "+ firstName+  " is eating");
    }

    public void sleep(){
        System.out.println("\tA " + getClass().getName() + " named "+ firstName+ " is sleeping");
    }

    public void play(){
        System.out.println("\tA " + getClass().getName() + " named "+ firstName+ " is playing");
    }
    
    public void run(){
        System.out.println("\tA " + getClass().getName() + " named "+ firstName+ " is running");
    }

    @Override 
    public String toString(){
        String result = "";
        if(dob == null){
            result = lastName  + ", "  + firstName;
        }else{
            result = lastName + ", "  + firstName + " (" + dob.toString() + ")";
        }
        return result;
    }

    public boolean equals(Person p){
        boolean isEqual = false;
        if(p == null) isEqual = false;
        if(p == this) isEqual = true;
        if(!(p instanceof Person)) isEqual = false;   
        return isEqual;     
    }
}