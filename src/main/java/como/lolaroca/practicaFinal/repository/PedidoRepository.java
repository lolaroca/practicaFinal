package como.lolaroca.practicaFinal.repository;

import org.springframework.data.repository.CrudRepository;
import como.lolaroca.practicaFinal.model.PedidoModel;


public interface PedidoRepository extends CrudRepository<PedidoModel, Long>{
    
}