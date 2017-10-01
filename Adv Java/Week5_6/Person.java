
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
    private void setFirstName(String firstName){
         this.firstName = firstName;
    }

    void setLastName(String lastName){
         this.lastName = lastName;
    }

    //Class Methods
    @Override public String toString(){
         return "First name: " + firstName + " Last name: "  + lastName;
    }

//   public boolean equals(Person p){

//         Class testClass = p.getClass();
//         boolean isPerson = testClass.isInstance(Person)? true : false;
//         return isPerson;
//     }

    void eat(){
        System.out.println("A " + getClass().getName() + " is eating");
    }

    void sleep(){
        System.out.println("A " + getClass().getName() + " is sleeping");
    }

    void play(){
        System.out.println("A " + getClass().getName() + " is playing");
    }
    

    void run(){
        System.out.println("A " + getClass().getName() + " is running");
    }
}