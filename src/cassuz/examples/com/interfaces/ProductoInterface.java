package cassuz.examples.com.interfaces;

import cassuz.examples.com.beans.Productos;

import java.io.File;
import java.util.List;

public interface ProductoInterface extends EntidadInterface<Productos> {
    public String Importar(File file);
}
