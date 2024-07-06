package com.sbl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbl.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
