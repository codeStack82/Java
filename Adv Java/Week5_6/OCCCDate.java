import java.util.GregorianCalendar;
import java.util.Date;

public class OCCCDate{
    private int dayOfMonth;
    private int monthOfYear;
    private int year;
    private GregorianCalendar gc;
    private boolean dateFormat;
    private boolean dateStyle;

    public static final boolean OCCCDATE_US = true;
    public static final boolean OCCCDATE_EURO = false;
    public static final boolean OCCCDATE_STYLE_NUMBERS = true;
    public static final boolean OCCCDATE_STYLE_NAMES = false;

    //Constructors
    OCCCDate(){};

    OCCCDate(int day, int month, int year){
        this.dayOfMonth = day;
        this.monthOfYear = month;
        this.year = year;
    };

    OCCCDate(GregorianCalendar gc){
        this.gc = gc;
    }

    OCCCDate(OCCCDate d){};

    //Getters
    int getDayOfMonth(){
        return gc.get(DAY_OF_MONTH);
    }

    String getDayOfWeek(){
        return gc.get(DAY_OF_WEEK);
    }

     String getMonth(){
        return gc.get(DAY_OF_WEEK);
    }

    String getNameOfMonth(){
        return "Test Name of Month";
    }

    int getYear(){
        return year;
    }

    //Setters
    void setDateFormat(boolean df){
        
    }

    void setStyleFormat(boolean sf){

    }


//    @override public boolean equals(OCCCDate d){
//         Class testClass = d.getClass();
//         boolean isOCCCDate = testClass.isInstance(OCCCDate)? true : false;
//         return isOCCCDate;
   
//     }

    //Stub 
    @Override public String toString(){
        String dateFormat = "";

        String US = new String("mm/dd/yyy");
        String EURO = new String("dd/mm/yyy");

        if(OCCCDATE_US){
            result = US;
        }else{
            result = EURO;
        }
        return dateFormat;
    }
}