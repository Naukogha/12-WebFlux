package com.example.demo;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.UUID;

@Service
public class NotificationService {

    public Flux<Notification> getNotification() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(i -> new Notification(
                        UUID.randomUUID().toString(),
                        "Message : " +i,
                        i % 2 ==0
                ))
                .log();
    }

    public Flux<Notification> getFilterNotification(){
        return  getNotification()
                .filter(Notification::isUrgent)
                .map(notification -> {
                    notification.setMessage(notification.getMessage()+ " URGENT");
                    return notification;
                });
    }
}
