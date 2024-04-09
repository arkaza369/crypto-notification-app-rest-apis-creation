package com.example.cryptonotificationapp.controller;

import com.example.cryptonotificationapp.model.Notification;
import com.example.cryptonotificationapp.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.createNotification(notification);
        return new ResponseEntity<>(createdNotification, HttpStatus.CREATED);
    }

    @PostMapping("/send-email")
    public ResponseEntity<String> sendNotificationEmail(@RequestBody Notification notification) {
        boolean result = notificationService.sendNotificationEmail(notification);
        if (result) {
            return ResponseEntity.ok("Notification email sent successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send notification email.");
        }
    }

    @GetMapping
    public ResponseEntity<List<Notification>> listNotifications() {
        List<Notification> notifications = notificationService.listNotifications();
        return ResponseEntity.ok(notifications);
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long notificationId) {
        notificationService.deleteNotification(notificationId);
        return ResponseEntity.noContent().build();
    }
}
