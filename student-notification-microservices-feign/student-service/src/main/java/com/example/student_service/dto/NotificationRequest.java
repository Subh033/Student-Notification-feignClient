package com.example.student_service.dto;

import lombok.Data;

@Data
public class NotificationRequest {
    private String id;
    private String message;

    public NotificationRequest(String id, String message) {
        this.id=id;
        this.message=message;
    }
}
