package org.example.exo8;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    //    GET /api/orders : Retourne toutes les commandes.
    @GetMapping
    public Flux<Order> getAllorders() {
        return orderService.getAllOrders();
    }

    //    GET /api/orders/{id} : Retourne une commande par ID.
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Order>> getOrderById(@PathVariable("id") int id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    //    POST /api/orders : Crée une nouvelle commande.
    @PostMapping
    public Mono<Order> createOrder(@RequestBody String customer, @RequestBody Double amout) {
        return orderService.createOrder(customer, amout);
    }

    //    PUT /api/orders/{id} : Met à jour le statut d’une commande.
    @PutMapping("/{id}")
    public Mono<ResponseEntity<Order>> updateOrder(@PathVariable int id,@RequestBody Order order) {
        return orderService.updateOrder(id,order)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    //    DELETE /api/orders/{id} : Supprime une commande par ID.
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteOrder(@PathVariable int id) {
        return orderService.deleteOrder(id)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }

    //    GET /api/orders/search?status=SHIPPED : Recherche les commandes par statut.
    @GetMapping ("")

//    GET /api/orders/paged?page=0&size=5 : Retourne les commandes paginées.
}
