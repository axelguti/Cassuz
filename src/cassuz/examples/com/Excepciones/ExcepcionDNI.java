package cassuz.examples.com.Excepciones;

public class ExcepcionDNI extends Exception{
    public ExcepcionDNI(){super();}
    public ExcepcionDNI(String message){super(message);}
    public ExcepcionDNI(String message, Exception cause){super(message,cause);}

}
