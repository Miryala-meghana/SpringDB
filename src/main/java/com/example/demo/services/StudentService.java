package com.example.demo.services;

import com.example.demo.Repository.StudentRepo;
import com.example.demo.models.Student;
import com.example.demo.models.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    StudentRepo studentrepo;

    @Autowired
    public StudentService(StudentRepo studentrepo) {
        this.studentrepo=studentrepo;

    }
    public Student createStudent(StudentInfo studentInfo)
    {
        Student student=new Student();
        student.setFirstname(studentInfo.getFirstname());
        student.setLastname(studentInfo.getLastname());
        return studentrepo.save(student);

    }
    public Iterable<Student> getAllStudents() {
        return studentrepo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentrepo.findById(id);
    }
}
