package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @GetMapping("/notifications")
    public Flux<Notification> getNotification (){
        return notificationService.getNotification();
    }

    @GetMapping("/urgence")
    public Flux<Notification> getUrgence(){
        return notificationService.getFilterNotification();
    }

    @GetMapping(value = "notiftext", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getNotifText(){
        return notificationService.getFilterNotification()
                .map(notification -> "Notification : " + notification);
    }
}
