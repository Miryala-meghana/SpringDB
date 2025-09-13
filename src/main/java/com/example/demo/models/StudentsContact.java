package com.example.demo.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="students_contact")
public class StudentsContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String email;
    private String phone;

    @OneToOne(mappedBy = "contact")
    private Student student;
}
