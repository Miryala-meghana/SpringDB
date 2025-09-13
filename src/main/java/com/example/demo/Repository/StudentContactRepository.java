package com.example.demo.Repository;

import com.example.demo.models.StudentsContact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentContactRepository extends CrudRepository <StudentsContact,Long>{

    @Query(value = "select * from students_contact as s where s.id= ?1",nativeQuery = true)
    public StudentsContact searchByContactId(Long id);
}
