package com.example.student_service.controller;

import com.example.student_service.client.NotificationClient;
import com.example.student_service.dto.NotificationRequest;
import com.example.student_service.model.Student;
import com.example.student_service.repository.StudentRepository;
import com.example.student_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

   @Autowired
   private StudentService studentService;

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.ok("Student saved and notification sent");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable String id,@RequestBody String course) {
        studentService.updateCourse(id,course);
        return ResponseEntity.ok("Student and notification Updated Successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student and notification Deleted");
    }
}
