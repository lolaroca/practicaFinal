package como.lolaroca.practicaFinal.service.impl;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import como.lolaroca.practicaFinal.join.UserPagarJoin;
import como.lolaroca.practicaFinal.join.UserPedidoJoin;
import como.lolaroca.practicaFinal.model.UserModel;
import como.lolaroca.practicaFinal.repository.UserRepository;
import como.lolaroca.practicaFinal.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;

    @Autowired
    private JdbcTemplate template;

    @Override
    public Iterable<UserModel> retrieveAll() {
        return repository.findAll();
    }

    @Override
    public UserModel create(UserModel user) {
        user.setUserId(null);
        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserModel user = repository.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        UserDetails newUser = new User(user.getUsername(), user.getPassword(), authorities);
        return newUser;
    }


    @Override
    public Iterable<UserPedidoJoin> retrieveUsuarioyPedido(String id) {
        String query = "SELECT USERS.USERNAME, USERS.EMAIL, USERS.COUNTRY, USERS.HOME_ADDRESS, USERS.PEDIDO_ID, PEDIDO.PEDIDO_NAME, PEDIDO.FOOD_ID, PEDIDO.PRICE_PEDIDO FROM USERS, PEDIDO WHERE USERS.PEDIDO_ID = PEDIDO.PEDIDO_ID AND PEDIDO.PEDIDO_ID="+ id;//id es una variable
        Iterable<UserPedidoJoin> userPedidoJoins = template.query(
            query,
            (data, rowNum) -> { //te devuelve estas dos cosas: 
                return new UserPedidoJoin( //nos devuelve un user nuevo 
                    data.getString("USERS.USERNAME"),
                    data.getString("USERS.EMAIL"),
                    data.getString("USERS.COUNTRY"),
                    data.getString("USERS.HOME_ADDRESS"),
                    data.getLong("USERS.PEDIDO_ID"),
                    data.getString("PEDIDO.PEDIDO_NAME"),
                    data.getLong("PEDIDO.FOOD_ID"),
                    data.getFloat("PEDIDO.PRICE_PEDIDO")
                );
            }
        );

        return userPedidoJoins; //me devuelve mi nueva tabla. 
    }

    @Override
    public Iterable<UserPagarJoin> retrieveUserPagar(String id) {
        String query = "SELECT USERS.USER_ID, USERS.USERNAME, USERS.PASSWORD, USERS.EMAIL, USERS.COUNTRY, USERS.HOME_ADDRESS, PAGAR.CARD_NUMBER, PAGAR.CARD_NAME, PAGAR.PRICE_PEDIDO FROM USERS, PAGAR WHERE USERS.USER_ID = PAGAR.USER_ID AND PAGAR.USER_ID="+ id;//id es una variable
        Iterable<UserPagarJoin> userPagarJoins = template.query(
            query,
            (data, rowNum) -> { //te devuelve estas dos cosas: 
                return new UserPagarJoin(
                    data.getLong("USERS.USER_ID"),
                    data.getString("USERS.USERNAME"),
                    data.getString("USERS.PASSWORD"),
                    data.getString("USERS.EMAIL"),
                    data.getString("USERS.COUNTRY"),
                    data.getString("USERS.HOME_ADDRESS"),
                    data.getLong("PAGAR.CARD_NUMBER"), //cojo de la tabla user la columna userid y la meto en el constructor como un long 
                    data.getString("PAGAR.CARD_NAME"),
                    data.getFloat("PAGAR.PRICE_PEDIDO")
                );
            }
        );

        return userPagarJoins; //me devuelve mi nueva tabla. 
    }

    @Override
    public String creaUsuario(UserModel usuario) {
        Long userId1 = usuario.getUserId();
        boolean usuarioExists = repository.existsById(userId1);
        if(usuarioExists){
            return "User Already Exists.";
        }else{
            Long userId = usuario.getUserId();
            String username = usuario.getUsername();
            String email = usuario.getEmail();
            String country = usuario.getCountry();
            String address = usuario.getAddress();
            Long pedidoId = usuario.getPedidoId();
            String password = usuario.getPassword();
            repository.creaUsuario(userId,username,email,country,address,pedidoId,password);
            return "OK";
        }
    }


    
}
