package org.example.demo2;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@Service
public class ProductService {

    private final Map<String, Product> products = new ConcurrentHashMap<>();

    public ProductService(){
        products.put("1", new Product("1", "Livre", BigDecimal.valueOf(0.99)));
        products.put("2", new Product("2", "Tomate", BigDecimal.valueOf(17.45)));
    }

    public Flux<Product> getAllProducts(){
        return Flux.fromIterable(products.values());
    }

    public Mono<Product> getProducById(String id){
        return Mono.justOrEmpty(products.get(id));
    }

    public Mono<Product> createProduct(Product product){
        String id = UUID.randomUUID().toString();
        product.setId(id);
        products.put(id, product);
        return Mono.just(product);
    }

}
