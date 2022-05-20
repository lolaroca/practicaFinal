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

import como.lolaroca.practicaFinal.model.PagarModel;
import como.lolaroca.practicaFinal.repository.PagarRepository;

import static org.assertj.core.api.BDDAssertions.then;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PagarE2ETest {
    @LocalServerPort
    private int port;

    @Autowired
    private PagarRepository repository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void pagarGetTest() {
        Iterable<como.lolaroca.practicaFinal.model.PagarModel> pagar = repository.findAll();

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/pagar";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<PagarModel>> result = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<PagarModel>>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(pagar);
    }
}