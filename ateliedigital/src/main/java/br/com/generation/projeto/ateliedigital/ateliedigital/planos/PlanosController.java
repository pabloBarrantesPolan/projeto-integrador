package br.com.generation.projeto.ateliedigital.ateliedigital.planos;


import br.com.generation.projeto.ateliedigital.ateliedigital.resourceNotFoundException.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlanosController {

    @Autowired
    private PlanosRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/novo/planos")
    public Planos Save(@RequestBody Planos planos){

        return repository.save(planos);

    }

    @GetMapping("/planos")
    public List<Planos> findAll(){
        return repository.findAll();
    }

    @PutMapping("/planos/{id}")
    public Planos Update(@PathVariable Long id, @RequestBody Planos planos) throws ResourceNotFoundException {

        return repository.findById(id).map( p -> {
            p.setNome(planos.getNome());
            p.setValor(planos.getValor());
            p.setDuracao(planos.getDuracao());
            return repository.save(p);
        }).orElseThrow(()->
                new ResourceNotFoundException("Não existe esse usuario"));

    }

    @DeleteMapping("/planos/{id}")
    public void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }
}
