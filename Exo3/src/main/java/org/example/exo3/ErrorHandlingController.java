package org.example.exo3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ErrorHandlingController {

    @GetMapping("/api/error-resume")
    public Flux<String> errorResume(){
        return Flux.just("A","B","C","D")
                .map(value -> {
                    if ("D".equals(value)){
                        throw new RuntimeException("Erreur simuler !!!");
                    }
                    return value;
                })
                .onErrorResume(e -> Flux.just(" Default1", " Default2"));
    }

    @GetMapping("/api/error-continue")
    public Flux<Integer>errorContinue(){
        return Flux.range(1, 5)
                .map(n -> {
                    if(n == 2){
                        throw new RuntimeException("Erreur simuler !!! pour : "+ n );
                    }
                    return n;
                })
                .onErrorContinue((e,value) -> {
                    System.err.println("Erreur avec : "+value +" -> : "+ e.getMessage());
                });
    }
}


//GET /api/error-resume : Retourne un Flux<String>:
    //Simule une erreur après "C".
    //Fournit des valeurs par défaut "Default1" et "Default2".
//GET /api/error-continue : Retourne un Flux<Integer>:
    //Génère un flux de nombres de 1 à 5.
    //Simule une erreur pour le nombre 2.
    //Ignore l’erreur et continue avec les autres valeurs.