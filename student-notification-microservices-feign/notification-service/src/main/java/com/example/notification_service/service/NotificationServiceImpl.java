package com.example.notification_service.service;

import com.example.notification_service.model.Notification;
import com.example.notification_service.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public String saveNotification(Notification notification) {
        notificationRepository.save(notification);
        return "Notification saved";
    }

    @Override
    public String deleteNotification(String id) {
        notificationRepository.deleteById(id);
        return "Deleted Notification Successfully";
    }

    @Override
    public String updateNotification(String id, String message) {
        Optional<Notification> existing=notificationRepository.findById(id);
        if (existing.isPresent())
        {
            Notification notification=existing.get();
            notification.setMessage(message);
            notificationRepository.save(notification);
            return "Updated Notification Successfully";
        }else{
             throw new RuntimeException("Notification not found with ID: " + id);
        }
    }
}
