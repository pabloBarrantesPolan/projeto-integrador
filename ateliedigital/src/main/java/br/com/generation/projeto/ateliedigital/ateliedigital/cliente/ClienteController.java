package br.com.generation.projeto.ateliedigital.ateliedigital.cliente;

import br.com.generation.projeto.ateliedigital.ateliedigital.resourceNotFoundException.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/novo/cliente")
    public Cliente Save(@RequestBody Cliente cliente){

        return repository.save(cliente);

    }

    @GetMapping("/clientes")
    public List<Cliente> findAll(){
        return repository.findAll();
    }

    @PutMapping("/clientes/{id}")
    public Cliente Update(@PathVariable Long id, @RequestBody Cliente cliente) throws ResourceNotFoundException {

          return repository.findById(id).map( cliente1 -> {
            cliente1.setNome(cliente.getNome());
            cliente1.setEmail(cliente.getEmail());
            cliente1.setCep(cliente.getCep());
            cliente1.setNumero(cliente.getNumero());
            cliente1.setSenha(cliente.getSenha());
            return repository.save(cliente1);
          }).orElseThrow(()->
                  new ResourceNotFoundException("Não existe esse usuario"));

        }

    @DeleteMapping("/clientes/{id}")
    public void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }

}


