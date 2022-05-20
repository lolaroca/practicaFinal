package como.lolaroca.practicaFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import como.lolaroca.practicaFinal.join.DiscountUser;
import como.lolaroca.practicaFinal.service.DiscountService;


@RestController
@RequestMapping("/api/v1")
public class DiscountController {
    @Autowired
    private DiscountService service;


    @GetMapping("/descuentoUsuario/{id}") //nos devuelve la información de los usuarios
    public ResponseEntity<Iterable<DiscountUser>> retrieveDiscountUser(@PathVariable String id) {
        return ResponseEntity.ok().body(service.retrieveDiscountUser(id));
    }
    
}
