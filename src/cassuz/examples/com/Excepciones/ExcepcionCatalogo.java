package cassuz.examples.com.Excepciones;

public class ExcepcionCatalogo extends Exception{
    public ExcepcionCatalogo(){super();}
    public ExcepcionCatalogo(String message){super(message);}
    public ExcepcionCatalogo(String message, Exception cause){super(message,cause);}
}
