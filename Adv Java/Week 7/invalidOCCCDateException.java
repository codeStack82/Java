/*
 * Tyler Hunt
 * Advanced Java
 * OCCC Fall 2017
 * Week 7
*/
import java.util.Scanner;

public class invalidOCCCDateException extends IllegalArgumentException{
    public String msg;
    public static final String DEFAULT_INVALDIOCCCDATEEXCEPTION_MESSAGE = "Invalid Date";
        public invalidOCCCDateException(){
            super();
            msg = DEFAULT_INVALDIOCCCDATEEXCEPTION_MESSAGE;
        }

        public invalidOCCCDateException(String msg){
            super();
            this.msg = new String(msg);
        }

        @Override
        public String getMessage(){
            return new String(msg);
        }

        @Override
        public String toString(){
            return getClass().getName() + ": " + msg;
        }
}

