package br.com.generation.projeto.ateliedigital.ateliedigital.cep;


import br.com.generation.projeto.ateliedigital.ateliedigital.gato.GatoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cep/")
public class CepController {
    private static  final Logger logger = LoggerFactory.getLogger(GatoService.class);

    @Autowired
    private CepService cepService;
//TODO- resolver esse controller
    @GetMapping("{numeroCep}")
    public Integer pegaEndereco(@PathVariable Integer numeroCep){
        return cepService.pegaEndereco(numeroCep);
    }

}
