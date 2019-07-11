package br.com.generation.projeto.ateliedigital.ateliedigital.fornecedor;

import br.com.generation.projeto.ateliedigital.ateliedigital.cliente.Cliente;
import br.com.generation.projeto.ateliedigital.ateliedigital.resourceNotFoundException.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FornecedorController {

    @Autowired
    private FornecedorRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/novo/fornecedore")
    public Fornecedor Save(@RequestBody Fornecedor fornecedor){

        return repository.save(fornecedor);

    }

    @GetMapping("/fornecedores")
    public List<Fornecedor> findAll(){
        return repository.findAll();
    }

    @PutMapping("/fornecedores/{id}")
    public Fornecedor Update(@PathVariable Long id, @RequestBody Fornecedor fornecedor) throws ResourceNotFoundException {

        return repository.findById(id).map( f -> {
            f.setNome(fornecedor.getNome());
            f.setEmail(fornecedor.getEmail());
            f.setCep(fornecedor.getCep());
            f.setCpf(fornecedor.getCpf());
            f.setNumero(fornecedor.getNumero());
            f.setSenha(fornecedor.getSenha());
            f.setIdPlano(fornecedor.getIdPlano());
            return repository.save(f);
        }).orElseThrow(()->
                new ResourceNotFoundException("Não existe esse usuario"));

    }

    @DeleteMapping("/fornecedores/{id}")
    public void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }
}
