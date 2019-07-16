package br.com.generation.projeto.ateliedigital.ateliedigital.planos;


import br.com.generation.projeto.ateliedigital.ateliedigital.resourceNotFoundException.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api
@RequestMapping("/api/v1/plano")
public class PlanosController {

    @Autowired
    private PlanosRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Salva um novo plano")
    @PostMapping("/novo")
    public Planos Save(@RequestBody Planos planos){

        return repository.save(planos);

    }

    @GetMapping("/mostra")
    @ApiOperation(value = "lista de planos")
    public List<Planos> findAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/mostra/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Pesquisa um plano pelo ID")
    public Optional<Planos> findById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PutMapping("/atualiza/{id}")
    @ApiOperation(value = "atualiza um plano pelo ID")
    public Planos Update(@PathVariable Long id, @RequestBody Planos planos) throws ResourceNotFoundException {

        return repository.findById(id).map( p -> {
            p.setNome(planos.getNome());
            p.setValor(planos.getValor());
            p.setDuracao(planos.getDuracao());
            return repository.save(p);
        }).orElseThrow(()->
                new ResourceNotFoundException("Não existe esse usuario"));

    }

    @DeleteMapping("/apaga/{id}")
    @ApiOperation(value = "elimina um plano pelo ID")
    public void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }
}
