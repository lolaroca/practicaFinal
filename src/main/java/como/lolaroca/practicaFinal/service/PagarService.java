package como.lolaroca.practicaFinal.service;

import como.lolaroca.practicaFinal.model.PagarModel;

public interface PagarService {
    Iterable <PagarModel> getPagos();
    void addPago(PagarModel pago);
    
}
