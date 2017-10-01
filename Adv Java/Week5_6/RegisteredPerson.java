public class RegisteredPerson extends Person{
    private String govID;

    //Constructors
    RegisteredPerson(String firstName, String LastName, String govID){
        super(firstName, lastName);
        this.govID  = new String(govID);
    }
    
    // RegisteredPerson(Person p, String govID){
    //    this.
    // }

    RegisteredPerson(RegisteredPerson rp){}
    
    //Getters
    String getGovernmentID(){
        return govID;
    }

    //defaults
    // @Override public boolean equals(RegisteredPerson rp){
    //     return true;
    // }

    // @Override public boolean equals(Person p){
    //     return true;
    // }

    @Override public String toString(){
        return super.toString() + " [" + govID + "]";
    }

}