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
import org.springframework.security.crypto.password.PasswordEncoder;

import como.lolaroca.practicaFinal.model.UserModel;
import como.lolaroca.practicaFinal.repository.UserRepository;

import static org.assertj.core.api.BDDAssertions.then;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserE2ETest {
    @LocalServerPort
    private int port;

    //no voy a acceder a nada de base de datos por eso no pongo repository ni service 


    @Autowired
    private TestRestTemplate restTemplate;

    //esto se hace para 
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    //voy a comprobar que ocurre cuando YO meto informacion 
    @Test
    public void userPostTest() {
        UserModel user = new UserModel();
        user.setUsername("user4");
        user.setEmail("algo");
        user.setPassword("password");

        //ocurre que users esta restringida entonces tengo que meterle autorizacion 
        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/users";
        HttpHeaders headers = new HttpHeaders();
        //metemos autorizacion para que vean q yo tengo acceso 
        //conversion a base 64 
        headers.add("Authorization", "Basic dXNlcjE6cXdlcnR5MTIz");
        //he anadido eso a los headers 
        HttpEntity<UserModel> entity = new HttpEntity<>(user,headers);
        //entity son los headers y body, antes no teniamso body ahora si y es un usermodel 
        //pq ahora tenemos body y antes no???

        //antes querias get y ahora es post por eso hay body 
        ResponseEntity<UserModel> result = restTemplate.exchange(
            url,
            HttpMethod.POST, //metodo
            entity,
            new ParameterizedTypeReference<UserModel>(){}
        );
        //voy a cambiar mi contrasena a un token que no se puede revertir 
        //hago la llamada y cojo la contrasena de lo que me devuelve 
        //aunque esto no se debe hacer 
        user.setPassword(result.getBody().getPassword());
        //hago metodo equals en mi user model 
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(user);
    }
    @Test
    public void userGetTest() {
        Iterable<UserModel> users = repository.findAll();

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/documents";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<UserModel>> result = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<UserModel>>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(users);
    }
}