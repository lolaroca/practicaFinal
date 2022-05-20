package como.lolaroca.practicaFinal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import como.lolaroca.practicaFinal.join.UserPagarJoin;
import como.lolaroca.practicaFinal.join.UserPedidoJoin;
import como.lolaroca.practicaFinal.model.UserModel;
import como.lolaroca.practicaFinal.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/users") //nos devuelve todos los users que haya
    public ResponseEntity<Iterable<UserModel>> retrieveAll() {
        return ResponseEntity.ok().body(service.retrieveAll()); //en el body nos devuleve todo 
    }

    @GetMapping("/pedidosUsers/{id}") //nos devuelve la información de los usuarios
    public ResponseEntity<Iterable<UserPedidoJoin>> retrieveUsuarioyPedido(@PathVariable String id) {
        return ResponseEntity.ok().body(service.retrieveUsuarioyPedido(id));
    }

    @PostMapping("/users") //para registrar usuarios 
    public ResponseEntity<UserModel> create(@RequestBody UserModel user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword()); //asi encodeas la contraseña 
        user.setPassword(hashedPassword);

        UserModel newUser = service.create(user);
        return ResponseEntity.ok().body(newUser);
    }

    @GetMapping("/usersPagar/{id}") //nos devuelve la información de los usuarios
    public ResponseEntity<Iterable<UserPagarJoin>> retrieveUserPagar(@PathVariable String id) {
        return ResponseEntity.ok().body(service.retrieveUserPagar(id));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> creaUsuario(
        @RequestBody UserModel usuario,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<String>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
        }else{
            String comparar = service.creaUsuario(usuario);
            if(comparar == "OK"){
                return new ResponseEntity<String>("{\"result\" : \"OK\"}", HttpStatus.OK);
            }else{
                return null;
            }
        }
    }


}

