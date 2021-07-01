package cassuz.examples.com.Excepciones;

public class ExcepcionUsuario extends Exception{
    public ExcepcionUsuario(){super();}
    public ExcepcionUsuario(String message){super(message);}
    public ExcepcionUsuario(String message, Exception cause){super(message,cause);}
}
