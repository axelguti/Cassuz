package cassuz.examples.com.interfaces;

import cassuz.examples.com.DTO.PromotorDTO;

import java.util.List;

public interface PromotorInterface extends EntidadInterface<PromotorDTO>{
    public PromotorDTO buscar(Object id);
}
