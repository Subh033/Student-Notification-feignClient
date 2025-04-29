package com.example.notification_service.controller;

import com.example.notification_service.model.Notification;
import com.example.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<String> createNotification(@RequestBody Notification notification) {
        String result = notificationService.saveNotification(notification);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateNotification(@PathVariable String id,@RequestBody String message) {
        String result = notificationService.updateNotification(id,message);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable String id) {
        String result = notificationService.deleteNotification(id);
        return ResponseEntity.ok(result);
    }

}
