package org.example.exo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class OperationController {

    @GetMapping ("/api/processed-numbers")
    public Flux<String> getCalculPaire(){
        return Flux.range(1,10)
                .filter(n -> n % 2 ==0 )
                .map(n -> n * 10)
                .map(n -> "Processed: "+n+"; ");
    }

//    GET /api/processed-numbers : Retourne un Flux<String> :
//    Génère un flux de nombres de 1 à 10.
//    Filtre les nombres pairs.
//    Multiplie chaque nombre par 10.
//    Retourne chaque valeur sous la forme "Processed: X" (où X est le résultat).
}
