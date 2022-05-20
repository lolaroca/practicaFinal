package como.lolaroca.practicaFinal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import como.lolaroca.practicaFinal.model.PagarModel;
import como.lolaroca.practicaFinal.service.PagarService;

@RestController
@RequestMapping("/api/v1")
public class PagarController {
    @Autowired
    private PagarService service;

    @GetMapping("/viewPagos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<PagarModel>> getPagos() {
        return ResponseEntity.ok().body(service.getPagos());
    }


    @PostMapping("/newPago")
    public ResponseEntity<PagarModel> addPago(@RequestBody PagarModel pago) {
        service.addPago(pago);
        return ResponseEntity.ok().body(pago);
    }
    
}