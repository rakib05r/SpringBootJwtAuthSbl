package com.sbl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbl.entities.Student;
import com.sbl.repositories.StudentRepository;
import com.sbl.services.StudentService;

@RequestMapping("/student")
@RestController
public class StudentController {
	private final StudentService studentService;
	@Autowired
	StudentRepository repo;
	public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
	@PostMapping("/add")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student newStudent = studentService.addStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> allUsers() {
		List<Student> students = studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = studentService.getSingleStudent(id);
		return student;
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudents(@PathVariable int id,@RequestBody Student studentbody) {
	   Student student = studentService.updateSingleStudent(id, studentbody);
	   return student;
	}
	
	@DeleteMapping("/delete/{id}")
	public String removeStudent(@PathVariable int id) {
		String msg = studentService.deleteStudent(id);
		return msg;
	}
}
