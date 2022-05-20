package como.lolaroca.practicaFinal.service;

import como.lolaroca.practicaFinal.model.ElementoModel;

public interface ElementoService {
    Iterable <ElementoModel> getElementos();
    ElementoModel updateElemento(Long id, ElementoModel elemento);
    void deleteElemento(Long id);
    void addElemento(ElementoModel elemento);
    
}
