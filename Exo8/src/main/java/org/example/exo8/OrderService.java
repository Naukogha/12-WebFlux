package org.example.exo8;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //    Récupérer toutes les commandes.
    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    //    Récupérer une commande par ID.
    public Mono<Order> getOrderById(int id) {
        return orderRepository.findById(id);
    }

    //    Créer une nouvelle commande avec un statut par défaut PENDING.
    public Mono<Order> createOrder(String custom, Double totalAmout) {
        Order newOrder = new Order(custom, totalAmout, OrderStatus.PENDING);
        return orderRepository.save(newOrder);
    }

    //    Mettre à jour le statut d’une commande existante.
    public Mono<Order> updateOrder(int id, Order order) {
        return orderRepository.findById(id)
                .flatMap(existingOrder -> {
                    existingOrder.setCustomerName(order.getCustomerName());
                    existingOrder.setTotalAmount(order.getTotalAmount());
                    existingOrder.setStatus(order.getStatus());
                    existingOrder.setCreatedAt(order.getCreatedAt());
                    return orderRepository.save(existingOrder);
                });
    }

    //    Supprimer une commande
    public Mono<Void> deleteOrder(int id) {
        return orderRepository.deleteById(id);
    }
}
