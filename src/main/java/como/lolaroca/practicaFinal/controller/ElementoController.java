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

import como.lolaroca.practicaFinal.model.ElementoModel;
import como.lolaroca.practicaFinal.service.ElementoService;

@RestController
@RequestMapping("/api/v1")
public class ElementoController {
    @Autowired
    private ElementoService service;

    @GetMapping("/viewElementos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<ElementoModel>> getElementos() {
        return ResponseEntity.ok().body(service.getElementos());
    }

    @PutMapping("/updateElemento/{id}")
    public ResponseEntity<ElementoModel> UpdateElemento(@PathVariable Long id, @RequestBody ElementoModel elemento) {
        ElementoModel newElemento = service.updateElemento(id, elemento);
        if(newElemento==null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newElemento);
    }

    @DeleteMapping("/deleteElemento/{id}")
    public ResponseEntity<ElementoModel> deleteElemento(@PathVariable Long id) {
        service.deleteElemento(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/newElemento")
    public ResponseEntity<ElementoModel> addElemento(@RequestBody ElementoModel elemento) {
        service.addElemento(elemento);
        return ResponseEntity.ok().body(elemento);
    }
}
