package com.example.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ConsoleReactiveDemo {
    public static void main(String[] args) {
        //simple mono
        Mono<String> mono = Mono.just("Hello Wordl");
        mono.subscribe(System.out::println);

        //flux simple
        Flux<Integer> flux = Flux.just(1,2,3);
        flux.subscribe(System.out::println);

        //opération sur flux
        Flux<Integer> flux2 = Flux.range(1,10)
                    .filter(n->n%2 ==0)
                    .map(n-> n * 10);
        flux2.subscribe(System.out::println);

        //ereur avec onErrorResume
        Flux<String> errorFlux =Flux.just("A","B","C")
                .map(value -> {
                    if ("B".equals(value)){
                        throw new RuntimeException("Erreur simuler !!!");
                    }
                    return value;
                })
                .onErrorResume(e -> Flux.just("Default1", "Default2"));

        errorFlux.subscribe(System.out::println, error -> System.err.println("Erreu recup :" +error));

        //onErrorContinue
        Flux<Integer> errorFlux2 = Flux.range(1,5)
                .map(n -> {
                    if (n == 3){
                        throw new RuntimeException("Erreur simuler pour : " +n);
                    }
                    return n;
                })
                .onErrorContinue((e, value)->{
                    System.err.println("Erreur avec " +value);
                });
    }
}
