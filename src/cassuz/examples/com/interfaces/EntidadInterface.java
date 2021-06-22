package cassuz.examples.com.interfaces;

import java.util.List;

public interface EntidadInterface<T> {
    public String grabar(T t);
    public String modificar(T t);
    public String eliminar(Object id);
    public List<T> listar();


}
