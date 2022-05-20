package como.lolaroca.practicaFinal.controller; 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import como.lolaroca.practicaFinal.join.UserPedidoJoin;
import como.lolaroca.practicaFinal.model.PedidoModel;
import como.lolaroca.practicaFinal.repository.PedidoRepository;

import static org.assertj.core.api.BDDAssertions.then;


//para que sprinboot sepa q esto es un test 
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PedidoE2ETest {
    //quiero tener acceso a mi repositorio 
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    //coger el puerto ya que es aleatorio 
    @LocalServerPort
    private int port;

    //importante
    @Test
    public void pedidosEndpoinTest() {
        //lo que espero q me devuelva 
        //lista de usuarios 
        Iterable<PedidoModel> pedidos = pedidoRepository.findAll();

        //segunda parte: hacer la llamada
        //empiezo haciendo la url de la llamada 
        //puerto como variable 
        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/pedidos";
        //no hay cabeceras 
        //LA LIBRERIA NO ES LA PRIMERA
        //vacio
        HttpHeaders headers = new HttpHeaders();
        //para poder juntas headers con el body
        HttpEntity<String> entity = new HttpEntity<>(headers);

        //ejecutar la llamada (tercera parte)
        //ejecuto la llamada con restTestTemplate y el metodo exchange 
        ResponseEntity<Iterable<PedidoModel>> result = testRestTemplate.exchange(
            //argumentos de exchange 
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<PedidoModel>>(){}
        );

        //compruebo que ese result sea lo mismo que yo me espero 
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(pedidos);
    }

    @Autowired
    private JdbcTemplate template;

    /*@Test
    public void pedidosUsersJoinEndpoinTest() {
        //volvemos a ejecutar la sentencia 
        //este test siempre va a estar bien
        String query = "SELECT * FROM PEDIDO INNER JOIN USERS ON PEDIDO.PEDIDO_ID = USERS.PEDIDO_ID";
    
            Iterable<UserPedidoJoin> pedidoUserJoins = template.query(
                query,
                (data, rowNum) -> {
                    return new PedidoUserJoin(
                        data.getLong("PEDIDO.PEDIDO_ID"), //cojo de la tabla user la columna userid y la meto en el constructor como un long 
                        data.getString("PEDIDO.PEDIDO_NAME"),
                        data.getLong("PEDIDO.FOOD_ID"),
                        data.getLong("PEDIDO.PRICE_PEDIDO"),
                        data.getLong("USERS.USER_ID"),
                        data.getString("USERS.USER_NAME"),
                        data.getString("USERS.USER_PASSWORD"),
                        data.getString("USERS.EMAIL"),
                        data.getString("USERS.COUNTRY"),
                        data.getString("USERS.HOME_ADDRESS")
                        //lo hago asi con las 5 columnas que tengo en mis tablas y las quiero unir 
                    );
                }
            );
        
        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/pedidos/join";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<PedidoUserJoin>> result = testRestTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            //parameterized es para pasar de json a objetos java 
            new ParameterizedTypeReference<Iterable<PedidoUserJoin>>(){}
        );
        //compruebo que sea igual 
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(pedidoUserJoins);
    }*/

    /*@Test
    public void pedidosElementosJoinEndpoinTest() {
        String query = "SELECT * FROM PEDIDO INNER JOIN ELEMENTO ON PEDIDO.FOOD_ID = ELEMENTO.FOOD_ID";
        //metes el id del elemento y te saca todos los pedidos con ese elemento 
        Iterable<PedidoElementoJoin> pedidoElementoJoins = template.query(
            query,
            (data, rowNum) -> {
                return new PedidoElementoJoin(
                    data.getLong("PEDIDO.PEDIDO_ID"), //cojo de la tabla user la columna userid y la meto en el constructor como un long 
                    data.getString("PEDIDO.PEDIDO_NAME"),
                    data.getLong("PEDIDO.FOOD_ID"),
                    data.getLong("PEDIDO.PRICE_PEDIDO"),
                    data.getString("ELEMENTO.FOOD_NAME"),
                    data.getLong("ELEMENTO.PRICE_ELEMENTO"),
                    data.getString("ELEMENTO.INGREDIENTES"),
                    data.getLong("ELEMENTO.KALORIES")
                );
            }
        );
        
        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/elementos/join";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<PedidoUserJoin>> result = testRestTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            //parameterized es para pasar de json a objetos java 
            new ParameterizedTypeReference<Iterable<PedidoUserJoin>>(){}
        );
        //compruebo que sea igual 
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(pedidoElementoJoins);
    }*/
}
