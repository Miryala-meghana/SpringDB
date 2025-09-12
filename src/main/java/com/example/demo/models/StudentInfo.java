package com.example.demo.models;

import lombok.Data;
import org.springframework.web.bind.annotation.RestController;

@Data
public class StudentInfo {
    public String firstname;
    public String lastname;

}
