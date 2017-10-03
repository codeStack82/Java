/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 6
 * Due: 10/1/2107
 * RegisteredPerson Class
*/

public class RegisteredPerson extends Person{
    private String govID;

    //Constructors
    RegisteredPerson(String firstName, String lastName, String govID){
        super(firstName, lastName);
        this.govID  = new String(govID);
    }
    
    RegisteredPerson(Person p, String govID){
        super(p.getFirstName(), p.getLastName());
        this.govID = govID;
    }

    //RegisteredPerson(RegisteredPerson rp){}
    
    //Getters
    String getGovernmentID(){
        return govID;
    }

    public boolean equals(RegisteredPerson p){
        boolean isEqual = false;
        if(p == null) isEqual = false;
        if(p == this) isEqual = true;

        if(!(p instanceof RegisteredPerson)) isEqual = false;   
        
        return isEqual;     
    }

    @Override 
    public String toString(){
        return super.toString() + ", GovId: [" + govID + "]";
    }
}