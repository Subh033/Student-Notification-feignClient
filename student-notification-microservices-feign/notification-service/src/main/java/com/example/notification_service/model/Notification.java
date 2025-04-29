package com.example.notification_service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "notifications")
public class Notification {
    private String id;
    private String message;

    public Notification(String id, String message) {
        this.id = id;
        this.message = message;
    }
}
