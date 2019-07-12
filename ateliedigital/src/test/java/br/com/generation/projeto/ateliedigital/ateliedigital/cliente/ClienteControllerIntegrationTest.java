package br.com.generation.projeto.ateliedigital.ateliedigital.cliente;



import br.com.generation.projeto.ateliedigital.ateliedigital.AteliedigitalApplication;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AteliedigitalApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteControllerIntegrationTest  {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(String path){
        return "http://localhost:" + port + "/api/v1" + path;
    }

    @Test
    public void save(){

        Faker faker = new Faker();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {

            Cliente cliente = new Cliente();
            cliente.setNome(faker.name().firstName());
            cliente.setEmail(faker.name().username()+"@mail.com");
            cliente.setCep(random.nextInt(100000));
            cliente.setNumero(random.nextInt(10000));
            cliente.setSenha(faker.beer().malt()+ faker.chuckNorris());

            ResponseEntity<Cliente> postResponse = testRestTemplate.postForEntity(getRootUrl("/novo/cliente"), cliente, Cliente.class);

            assertNotNull(postResponse);
            assertEquals(201, postResponse.getStatusCodeValue());

        }
    }
//TODO- teste ClienteController- findAll()
//    @Test
//    public void findAll(){
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(getRootUrl("/clientes"), HttpMethod.GET, entity, String.class);
//        assertNotNull(response.getBody());
//
//    }
}
