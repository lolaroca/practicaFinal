package como.lolaroca.practicaFinal.service;

import como.lolaroca.practicaFinal.join.PedidoElementoJoin;
import como.lolaroca.practicaFinal.model.PedidoModel;

public interface PedidoService {
    Iterable <PedidoModel> GetPedidos();
    PedidoModel updatePedido(Long id, PedidoModel pedido);
    void deletePedido(Long id);
    void addPedido(PedidoModel pedido);
    Iterable<PedidoElementoJoin> retrieveElementoyPedido(String id);
}
