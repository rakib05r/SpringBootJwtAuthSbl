package com.sbl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sbl.entities.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
