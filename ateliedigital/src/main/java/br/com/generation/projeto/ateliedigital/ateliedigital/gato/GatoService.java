package br.com.generation.projeto.ateliedigital.ateliedigital.gato;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Service
public class GatoService {

    private static  final Logger logger = LoggerFactory.getLogger(GatoService.class);

    @GetMapping("gatos/{statusCode}")
        public String statusCodeToCat(@PathVariable Integer statusCode){

        String retorno = null;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://http.cat/"+ statusCode)
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            retorno = response.toString();
        } catch (IOException e) {
            logger.info("Ocorreu um erro na ora de consumir a API dos gatinhos");
        }

        return retorno;
    }
}
