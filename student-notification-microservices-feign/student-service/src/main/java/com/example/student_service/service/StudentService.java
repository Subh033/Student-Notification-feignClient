package com.example.student_service.service;

import com.example.student_service.model.Student;

public interface StudentService {
    String saveStudent(Student student);
    String deleteStudent(String id);
    String updateCourse(String id, String course);
}
