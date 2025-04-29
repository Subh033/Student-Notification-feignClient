package com.example.student_service.client;
import com.example.student_service.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notification-client", url = "http://localhost:8082")
public interface NotificationClient {
    @PostMapping("/notifications")
    String sendNotification(@RequestBody NotificationRequest request);

    @PutMapping("/notifications/{id}")
    String updateNotification(@PathVariable String id,@RequestBody String message);

    @DeleteMapping("/notifications/{id}")
    String deleteNotificatio(@PathVariable String id);
}