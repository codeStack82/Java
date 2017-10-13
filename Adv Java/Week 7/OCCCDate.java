/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 6
 * Due: 10/1/2107
 * OCCCDate Class
*/
import java.util.GregorianCalendar;
import java.util.Date;

public class OCCCDate{
    private int dayOfMonth;
    private int monthOfYear;
    private int year;
    private GregorianCalendar gc;
    private boolean dateFormat = true;
    private boolean dateStyle = true;

    //Not sure what these were for?
    public static final boolean OCCCDATE_US = true;
    public static final boolean OCCCDATE_EURO = false;
    public static final boolean OCCCDATE_STYLE_NUMBERS = true;
    public static final boolean OCCCDATE_STYLE_NAMES = false;

    //Constructors
    OCCCDate(){};

    OCCCDate(int day, int month, int year){
        if(day > 0 && day < 32){
            this.dayOfMonth = day;
        }else{
            this.dayOfMonth = 1;
        }
        if(month > 0 && month < 13){
            this.monthOfYear = month;
        }else{
             this.monthOfYear = 1;
        }
        if(year > 1899){
            this.year = year;
        }else{
            this.year = 1900; //default 
        }
    }

    OCCCDate(GregorianCalendar gc){
        this.dayOfMonth = gc.get(gc.DAY_OF_MONTH);
        this.monthOfYear = gc.get(gc.MONTH);
        this.year = gc.get(gc.YEAR);
    }

    OCCCDate(OCCCDate d){};

    //Getters
    public int getDayOfMonth(){
        return this.dayOfMonth;
    }

    public int getMonth(){
        return this.monthOfYear;
    }

    public int getYear(){
        return this.year;
    }

    public String getDayOfWeek(){
        int d = getDayOfMonth();
        int m = getMonth();
        int y = getYear();

        GregorianCalendar gc = new GregorianCalendar(y, m, d);
        int dayOfWeek        =  gc.get(gc.DAY_OF_WEEK);
        String day;
        switch (dayOfWeek) {
            case 1: day = "SUNDAY";
                break;
            case 2: day = "MONDAY";
                break;
            case 3: day = "TUESDAY";
                break;
            case 4: day = "WEDNESDAY";
                break;
            case 5: day = "THURSDAY";
                break;
            case 6: day = "FRIDAY";
                break;
            case 7: day = "SATURDAY";
                break;
            default: day = "";
                break;
        }
        return day;
    }

    public String getNameOfMonth(){
        int d = getDayOfMonth();
        int m = getMonth();
        int y = getYear();

        GregorianCalendar gc = new GregorianCalendar(y, m, d);
        int dayOfMonth = getMonth();
        String month;
         switch (dayOfMonth) {
            case 1: month = "JANUARY";
                break;
            case 2: month = "FEBRUARY";
                break;
            case 3: month = "MARCH";
                break;
            case 4: month = "APRIL";
                break;
            case 5: month = "MAY";
                break;
            case 6: month = "JUNE";
                break;
            case 7: month = "JULY";
                break;
            case 8: month = "AUGUST";
                break;
            case 9: month = "SEPTEMBER";
                break;
            case 10: month = "OCTOBER";
                break;
            case 11: month = "NOVEMBER";
                break;
            case 12: month = "DECEMBER";
                break;
            default: month = "";
                break;
        }
        return month;
    }

    //Setters
    public void setDateFormat(boolean dateFormat){
        this.dateFormat = dateFormat;
    }

    public void setStyleFormat(boolean dateStyle){
        this.dateStyle = dateStyle;

    }

    public int getDifferenceInYears(){
        GregorianCalendar today = new GregorianCalendar();
        int nowYear = today.get(GregorianCalendar.YEAR);
        int dobYear = this.year;
        int age = nowYear - dobYear > 0? nowYear - dobYear: 0;

        return age;
    }

    public int getDifferenceInYears(OCCCDate d){
        GregorianCalendar today = new GregorianCalendar();
        int nowYear = today.get(GregorianCalendar.YEAR);
        int dobYear = d.getYear();
        int age = nowYear - dobYear > 0? nowYear - dobYear: 0;

        return age;
    }

    public boolean equals(OCCCDate p){
        boolean isEqual = false;
        if(p == null) isEqual = false;
        if(p == this) isEqual = true;

        if(!(p instanceof OCCCDate)) isEqual = false;   
        
        return isEqual;     
    }
 
    @Override 
    public String toString(){

        String retDate = "";

        String d_str = getDayOfWeek();
        int d = getDayOfMonth();
        String m_str = getNameOfMonth();
        int m = getMonth();
        int y = getYear();

        String short_Us = String.format("%d/%d/%d",m,d,y);
        String long_Us = String.format("%s %d, %d",m_str,d,y);

        String short_Euro = String.format("%d/%d/%d",d,m,y);
        String long_Euro = String.format("%d %s, %d",d, m_str,y);

        if(dateFormat && dateStyle){            //us and number month
           retDate = short_Us;
        }else if(dateFormat && !dateStyle){     //us and word month
            retDate = long_Us;
        }else if(!dateFormat && dateStyle){     //euro and number month
            retDate = short_Euro;
        }else if(!dateFormat && !dateStyle){    //euro and word month
            retDate = long_Euro;
        }else{                                  //default us and number month
           retDate = short_Us;
        }

        return retDate;
    }
}