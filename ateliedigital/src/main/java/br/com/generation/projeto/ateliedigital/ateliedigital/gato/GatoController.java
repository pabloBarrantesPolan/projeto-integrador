package br.com.generation.projeto.ateliedigital.ateliedigital.gato;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/")
public class GatoController {

    private static  final Logger logger = LoggerFactory.getLogger(GatoService.class);

    @Autowired
    private GatoService gatoService;

    @GetMapping("gatos/{statusCode}")
    public String statusCodeToCat(@PathVariable Integer statusCode){
        return gatoService.statusCodeToCat(statusCode);
    }

}
