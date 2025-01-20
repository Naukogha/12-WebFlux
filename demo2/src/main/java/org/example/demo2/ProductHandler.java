package org.example.demo2;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {
    private final ProductService productService;

    public  ProductHandler (ProductService productService){
        this.productService=productService;
    }

    public Mono<ServerResponse> getAllProducts(ServerRequest request){
        return ServerResponse.ok().body(productService.getAllProducts(), Product.class);
    }

    public Mono<ServerResponse> getProductById(ServerRequest request){
        String id = request.pathVariable("id");
        return productService.getProducById(id)
                .flatMap(product -> ServerResponse.ok().bodyValue(product))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createProduct (ServerRequest request){
        return request.bodyToMono(Product.class)
                .flatMap(productService::createProduct)
                .flatMap(p -> ServerResponse.created(request.uri()).bodyValue(p));
    }
}
