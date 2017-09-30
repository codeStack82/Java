
//Week 5 implement all except OCCCDate

public class Person{
    private String firstName;
    private String lastName;
    //private Date OCCCDate;
        
    //Constructors
    public Person(String firstName, String lastName){
        this.firstName  = new String(firstName);
        this.lastName  = new String(lastName);
    }
    //, Date OCCCDate
    // public Person(String firstName, String lastName, ){
    //     this.firstName  = new String(firstName);
    //     this.lastName  = new String(lastName);
    //     //this.OCCCDate = new OCCCDate.getDefault();  //need to fix
    // }
    public Person(Person P){}  //Copy constructor

    //Getters
    public String getFirstName(){
        return new String(firstName);
    }
      
    public String getLastName(){
        return new String(lastName);
    }

    //Setters
    private void setFirstName(String fn){
         firstName = fn;
    }

    void setLastName(String ln){
         lastName = ln;
    }

    //Class Methods
  
  @Override public String toString(){
         return "First name: " + firstName + " Last name: "  +lastName;
    }

    // @Override
    // boolean equals(){
    //     // if(firstName == other firstName && lastName == other lastName){
    //     //     return true;
    //     // }
    // }

    void eat(){
        System.out.println("A " + getClass().getName() + " is eating");
    }

    void sleep(){
        System.out.println("Person is sleeping");
    }

    void play(){
        System.out.println("Person is playing");
    }

    void run(){
        System.out.println("Person is running");
    }

}