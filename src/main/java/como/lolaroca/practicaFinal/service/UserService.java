package como.lolaroca.practicaFinal.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import como.lolaroca.practicaFinal.join.UserPagarJoin;
import como.lolaroca.practicaFinal.join.UserPedidoJoin;
import como.lolaroca.practicaFinal.model.UserModel;
 
public interface UserService extends UserDetailsService {
    Iterable<UserModel> retrieveAll();
    UserModel create(UserModel user);
   // void addPagoUsuario(UserModel usuario);
    Iterable<UserPedidoJoin> retrieveUsuarioyPedido(String id); //nos devuelva la unión de los dos 
    Iterable<UserPagarJoin> retrieveUserPagar(String id);
    String creaUsuario(UserModel usuario);
}
