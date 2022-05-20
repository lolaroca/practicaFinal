package como.lolaroca.practicaFinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import como.lolaroca.practicaFinal.model.ElementoModel;
import como.lolaroca.practicaFinal.repository.ElementoRepository;
import como.lolaroca.practicaFinal.service.ElementoService;

@Service
public class ElementoServiceImpl implements ElementoService{

    @Autowired
    private ElementoRepository repository;
    
    @Override
    public Iterable<ElementoModel> getElementos() {
        return repository.findAll();
    }

    @Override
    public ElementoModel updateElemento(Long id, ElementoModel elemento) {
        if(repository.existsById(id)){
            return repository.save(elemento);
        }else{
            return null;
        }
    }

    @Override
    public void deleteElemento(Long id) {
        repository.deleteById(id);
        
    }

    @Override
    public void addElemento(ElementoModel elemento) {
        repository.save(elemento);
        
    }
    
}
