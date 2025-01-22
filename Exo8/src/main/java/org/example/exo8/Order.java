package org.example.exo8;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Order {

    @Id
    private Long id;
    private String customerName;
    private Double totalAmount;

    private OrderStatus status;
    private LocalDateTime createdAt;

    // Constructeurs
    public Order() {
        this.createdAt = LocalDateTime.now();
    }

    public Order(String customerName, Double totalAmount, OrderStatus order) {
        this();
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.status = order;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "createdAt=" + createdAt +
                ", id=" + id +
                ", customerName='" + customerName + '\'' +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                '}';
    }
}
