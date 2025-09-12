package com.example.demo.controller;

import com.example.demo.models.Student;
import com.example.demo.models.StudentInfo;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/createstudent")
    public Student createStudent(@RequestBody StudentInfo studentinfo) {
        return studentService.createStudent(studentinfo);
    }

    @GetMapping("/students")
    public Iterable<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)   // return 200 with student
                .orElse(ResponseEntity.notFound().build()); // return 404 if not found
    }
}



