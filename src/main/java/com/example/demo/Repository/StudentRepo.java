package com.example.demo.Repository;

import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

    @Query(value ="select * from students where firstname= ?1",nativeQuery = true )
    public List<Student> finbyFirstname(String firstname);
}
