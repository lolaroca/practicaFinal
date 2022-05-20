package como.lolaroca.practicaFinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import como.lolaroca.practicaFinal.join.PedidoElementoJoin;
import como.lolaroca.practicaFinal.model.PedidoModel;
import como.lolaroca.practicaFinal.repository.PedidoRepository;
import como.lolaroca.practicaFinal.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private JdbcTemplate template;

    @Override
    public Iterable<PedidoModel> GetPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public PedidoModel updatePedido(Long id, PedidoModel pedido) {
        if(pedidoRepository.existsById(id)){
            return pedidoRepository.save(pedido);
        }else{
            return null;
        }
       
    }

    @Override
    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
        
    }

    @Override
    public void addPedido(PedidoModel pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public Iterable<PedidoElementoJoin> retrieveElementoyPedido(String id) {
        String query = "SELECT  PEDIDO.PEDIDO_ID, PEDIDO.PEDIDO_NAME, PEDIDO.FOOD_ID,PEDIDO.PRICE_PEDIDO, ELEMENTO.FOOD_NAME, ELEMENTO.PRICE, ELEMENTO.INGREDIENTES, ELEMENTO.KALORIES FROM PEDIDO, ELEMENTO WHERE PEDIDO.FOOD_ID = ELEMENTO.FOOD_ID AND ELEMENTO.FOOD_ID="+ id;//id es una variable
        Iterable<PedidoElementoJoin> pedidoElementoJoins = template.query(
            query,
            (data, rowNum) -> { //te devuelve estas dos cosas: 
                return new PedidoElementoJoin( //nos devuelve un user nuevo 
                data.getLong("PEDIDO.PEDIDO_ID"), //cojo de la tabla user la columna userid y la meto en el constructor como un long 
                data.getString("PEDIDO.PEDIDO_NAME"),
                data.getLong("PEDIDO.FOOD_ID"),
                data.getFloat("PEDIDO.PRICE_PEDIDO"),
                data.getString("ELEMENTO.FOOD_NAME"),
                data.getFloat("ELEMENTO.PRICE"),
                data.getString("ELEMENTO.INGREDIENTES"),
                data.getLong("ELEMENTO.KALORIES")
                );
            }
        );

        return pedidoElementoJoins; //me devuelve mi nueva tabla. 
    }
    
}
