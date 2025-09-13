package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="FirstName")
    private String firstname;
    @Column(name="LastName")
    private  String lastname;

// Relationships one to one
//  this table is main table it is the owner side of the tables
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contact_id",referencedColumnName = "id")
    private StudentsContact contact;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<StudentAddress> addresses;

}
