package como.lolaroca.practicaFinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import como.lolaroca.practicaFinal.model.PagarModel;
import como.lolaroca.practicaFinal.repository.PagarRepository;
import como.lolaroca.practicaFinal.service.PagarService;

@Service
public class PagarServiceImpl implements PagarService {

    @Autowired
    private PagarRepository repository;

    @Override
    public Iterable<PagarModel> getPagos() {
        return repository.findAll();
    }

    @Override
    public void addPago(PagarModel pago) {
        repository.save(pago);
        
    }
    
}
