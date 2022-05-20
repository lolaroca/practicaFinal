package como.lolaroca.practicaFinal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import como.lolaroca.practicaFinal.join.PedidoElementoJoin;
import como.lolaroca.practicaFinal.model.PedidoModel;
import como.lolaroca.practicaFinal.service.PedidoService;

@RestController
@RequestMapping("/api/v1")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/viewPedidos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<PedidoModel>> GetPedidos() {
        return ResponseEntity.ok().body(pedidoService.GetPedidos());
    }

    @PutMapping("/updatePedido/{id}")
    public ResponseEntity<PedidoModel> UpdatePedido(@PathVariable Long id, @RequestBody PedidoModel pedido) {
        PedidoModel newPedido = pedidoService.updatePedido(id, pedido);
        if(newPedido==null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newPedido);
    }

    @DeleteMapping("/deletePedido/{id}")
    public ResponseEntity<PedidoModel> deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/newPedido")
    public ResponseEntity<PedidoModel> addPedido(@RequestBody PedidoModel pedido) {
        pedidoService.addPedido(pedido);
        return ResponseEntity.ok().body(pedido);
    }

    @GetMapping("/elementosPedidos/{id}") //nos devuelve la información de los usuarios
    public ResponseEntity<Iterable<PedidoElementoJoin>> retrieveElementoyPedido(@PathVariable String id) {
        return ResponseEntity.ok().body(pedidoService.retrieveElementoyPedido(id));
    }
    
}
