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
    OCCCDate()throws InvalidOCCCDateException{};

    OCCCDate(int day, int month, int year) throws InvalidOCCCDateException{
        boolean isValid = isValidDate(day, month, year);

        if(!isValid){
            throw new InvalidOCCCDateException("The date: " + month +"/" + day + "/"+ year +" in not a valid Date");
        }else{
            this.dayOfMonth = day;
            this.monthOfYear = month;
            this.year = year;
        }
    }

    OCCCDate(GregorianCalendar gc) throws InvalidOCCCDateException{
        boolean isValid = isValidDate(gc.get(gc.DAY_OF_MONTH), gc.get(gc.MONTH), gc.get(gc.YEAR));

        if(!isValid){
            throw new InvalidOCCCDateException("Test Date Validity df");
        }else{
            this.dayOfMonth = gc.get(gc.DAY_OF_MONTH);
            this.monthOfYear = gc.get(gc.MONTH);
            this.year = gc.get(gc.YEAR);
        }
    }

    OCCCDate(OCCCDate d)throws InvalidOCCCDateException{};

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
        int age = nowYear - dobYear > 0 ? nowYear - dobYear: 0;

        return age;
    }

    public int getDifferenceInYears(OCCCDate d){
        GregorianCalendar today = new GregorianCalendar();
        int nowYear = today.get(GregorianCalendar.YEAR);
        int dobYear = d.getYear();
        int age = nowYear - dobYear > 0? nowYear - dobYear: 0;

        return age;
    }

    public boolean equals(OCCCDate d){
        if(this.getDayOfMonth()==d.dayOfMonth && this.getMonth()==d.monthOfYear && this.getYear()==d.year){
			return true;
		}
		else{
			return false;
		}    
    }

    public boolean isValidDate(int day, int month, int year){
        GregorianCalendar cal = new GregorianCalendar(year, month, day);
        boolean isLeapYear = cal.isLeapYear(year);

        // System.out.println(day +" " + month + " " + year);
        // System.out.println(cal.get(cal.DAY_OF_MONTH) +" " + cal.get(cal.MONTH) + " " + cal.get(cal.YEAR));


        if( month < 1 || month > 12) return false;                       // validate month number
        if( year < 0)	return false;                                    // validate year number
        if(month == 4 || month == 6 || month == 9 || month == 11){       // validate days in month
			if( day > 30) return false;	
		}else if(day > 31) return false;
        if(!isLeapYear && month == 2 && day > 28)  return false;          //validate leap year extra day
        if(isLeapYear && month == 2 && day > 29)  return false;          //validate leap year extra day    
        return true;
    }

    public boolean isLeapYear(){
        GregorianCalendar cal = new GregorianCalendar(this.year, this.monthOfYear, this.dayOfMonth);
        return cal.isLeapYear(year);
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