package com.example.demo.controller;

import com.example.demo.models.Student;
import com.example.demo.models.StudentInfo;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/createstudent")
    public Student  createStudent(@RequestBody StudentInfo studentinfo) {
        return studentService.createStudent(studentinfo);
    }
}
