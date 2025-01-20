package org.example.exo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@RestController
public class BasicController {

    @GetMapping("/api/welcome") // Retourne un Mono<String> contenant "Welcome to Project Reactor!"
    public Mono<String> getHello(){
        return Mono.just("Welcome to Project Reactor!");
    }


    @GetMapping("api/numbers") //Retourne un Flux<Integer> contenant les nombres de 1 à 5.
    public Flux<Integer> getNumber (){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        return Flux.fromIterable(list)
                .delayElements(Duration.ofSeconds(2));
    }
}
