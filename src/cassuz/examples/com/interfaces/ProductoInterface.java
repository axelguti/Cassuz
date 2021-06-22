package cassuz.examples.com.interfaces;

import cassuz.examples.com.beans.Productos;

import java.util.List;

public interface ProductoInterface extends EntidadInterface<Productos> {
    List<Productos> Importar(Class<Productos> producto,String file);
}
