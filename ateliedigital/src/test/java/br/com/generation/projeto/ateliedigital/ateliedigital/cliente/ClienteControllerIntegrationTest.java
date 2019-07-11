package br.com.generation.projeto.ateliedigital.ateliedigital.cliente;


import br.com.generation.projeto.ateliedigital.ateliedigital.AteliedigitalApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AteliedigitalApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteControllerIntegrationTest  {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(){
        return "http://localhost:" + port;
    }

    @Test
    public void save(){
        System.out.printf("Teste!");
        Cliente cliente = new Cliente();
        cliente.setNome("Joao");
        cliente.setEmail("joao@joao");
        cliente.setCep(1235432);
        cliente.setNumero(1234);
        cliente.setSenha("joao123");
        //ResponseEntity<Cliente> postResponse = testRestTemplate.postForEntity(getRootUrl() + "/novo/cliente");
    }
}
