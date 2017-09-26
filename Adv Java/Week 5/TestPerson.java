public class TestPerson{
    public static void main(String [] aarrgs){
        RegisteredPerson rP1 = new RegisteredPerson("Tyler", "Hunt", "778547");
        Person p1 = new Person("Donald", "Trump");
        Person p2 = new Person("Peter", "Parker");
        Person p3 = new Person("Bill", "Clinton");

        System.out.println(p1.getLastName());
        System.out.println(p2.toString());
        System.out.println(p3.getLastName());

    }
}