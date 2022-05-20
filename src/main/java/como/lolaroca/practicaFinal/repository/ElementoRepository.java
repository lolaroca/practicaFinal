package como.lolaroca.practicaFinal.repository;

import org.springframework.data.repository.CrudRepository;

import como.lolaroca.practicaFinal.model.ElementoModel;


public interface ElementoRepository extends CrudRepository<ElementoModel, Long>{
  
}