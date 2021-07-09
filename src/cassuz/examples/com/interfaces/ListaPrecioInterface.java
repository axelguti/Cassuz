package cassuz.examples.com.interfaces;

import cassuz.examples.com.DTO.ListaPreciosDTO;
import java.io.File;

public interface ListaPrecioInterface extends EntidadInterface<ListaPreciosDTO> {
    public String Importar(File file);
}
