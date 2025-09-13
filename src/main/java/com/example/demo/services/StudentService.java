package com.example.demo.services;

import com.example.demo.Repository.StudentContactRepository;
import com.example.demo.Repository.StudentRepo;
import com.example.demo.models.Student;
import com.example.demo.models.StudentAddress;
import com.example.demo.models.StudentInfo;
import com.example.demo.models.StudentsContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepo studentrepo;
    private final StudentContactRepository studentContactRepository;

    @Autowired
    public StudentService(StudentRepo studentrepo, StudentContactRepository studentContactRepository) {
        this.studentrepo=studentrepo;

        this.studentContactRepository = studentContactRepository;
    }
    public Student createStudent(StudentInfo studentInfo)
    {
        Student student=new Student();
        student.setFirstname(studentInfo.getFirstname());
        student.setLastname(studentInfo.getLastname());

        StudentsContact contact=new StudentsContact();
        contact.setEmail("thathiamma@gmail.com");
        contact.setPhone("99547344637");
        student.setContact(contact);

        StudentAddress currentAddress=new StudentAddress();
        currentAddress.setCountry("India");
        currentAddress.setState("TS");
        currentAddress.setStreet("myStreet");
        currentAddress.setZipcode("5672835");

        StudentAddress perAddress=new StudentAddress();
        perAddress.setCountry("India");
        perAddress.setState("UP");
        perAddress.setStreet("earlybirdlayout");
        perAddress.setZipcode("567284");
        student.setAddresses(List.of(currentAddress,perAddress));

        return studentrepo.save(student);

    }
    public Iterable<Student> getAllStudents() {
        return studentrepo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentrepo.findById(id);
    }
    public StudentInfo findStudentOfContactById(Long contactId)
    {
        StudentsContact studentsContact=studentContactRepository.searchByContactId(contactId);
        StudentInfo studentinfo=new StudentInfo();
        studentinfo.firstname=studentsContact.getStudent().getFirstname();
        studentinfo.lastname=studentsContact.getStudent().getLastname();
        return studentinfo;
    }
}
