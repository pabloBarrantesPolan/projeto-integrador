package br.com.generation.projeto.ateliedigital.ateliedigital.fornecedor;

import br.com.generation.projeto.ateliedigital.ateliedigital.cliente.Cliente;
import br.com.generation.projeto.ateliedigital.ateliedigital.resourceNotFoundException.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api
@RequestMapping("/api/v1/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/novo")
    @ApiOperation(value = "Salva um novo fornecedor")
    public Fornecedor Save(@RequestBody Fornecedor fornecedor){

        return repository.save(fornecedor);

    }

    @GetMapping("/lista")
    @ApiOperation(value = "lista os fornecedores")
    public List<Fornecedor> findAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/mostra/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Pesquisa um fornecedor pelo ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "tudo certo"),
            @ApiResponse(code = 201, message = "Inserido"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 403, message = "tururu"),
            @ApiResponse(code = 404, message = "probrema no sitema")
    })

    public Optional<Fornecedor> findById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PutMapping("/mostra/{id}")
    @ApiOperation(value = "atualiza um fornecedor pelo ID")
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

    @DeleteMapping("/elimina/{id}")
    @ApiOperation(value = "elimina um fornecedor pelo ID")
    public void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }
}
