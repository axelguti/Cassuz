package cassuz.examples.com.interfaces;

import cassuz.examples.com.beans.ListaPrecios;
import java.io.File;

public interface ListaPrecioInterface extends EntidadInterface<ListaPrecios> {
    public String Importar(File file);
}
