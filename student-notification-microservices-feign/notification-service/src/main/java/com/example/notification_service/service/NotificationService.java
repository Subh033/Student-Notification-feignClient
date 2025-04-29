package com.example.notification_service.service;

import com.example.notification_service.model.Notification;

public interface NotificationService {

    String saveNotification(Notification notification);
    String deleteNotification(String id);
    String updateNotification(String id, String message);
}
