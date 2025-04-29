package com.example.student_service.service;

import com.example.student_service.client.NotificationClient;
import com.example.student_service.dto.NotificationRequest;
import com.example.student_service.model.Student;
import com.example.student_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.AnnotatedArrayType;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private NotificationClient notificationClient;

    @Override
    public String saveStudent(Student student) {
        studentRepository.save(student);

        String message = "Welcome " + student.getName() + " to the " + student.getCourse() + " course!";
        NotificationRequest notificationRequest = new NotificationRequest(student.getId(),message);

        notificationClient.sendNotification(notificationRequest);
        return "Student saved and notification sent";
    }

    @Override
    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        notificationClient.deleteNotificatio(id);
        return "Deleted Student Successfully";
    }

    @Override
    public String updateCourse(String id, String course) {

        Optional<Student> existing=studentRepository.findById(id);
        if (existing.isPresent())
        {
            Student student=existing.get();
            student.setCourse(course);
            studentRepository.save(student);
            String message="Welcome " + student.getName() + " to the " + course + " course!";
            notificationClient.updateNotification(id,message);
            return "Updated Notification Successfully";
        }else{
            throw new RuntimeException("Notification not found with ID: " + id);
        }
    }
}


