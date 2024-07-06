package com.sbl.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.sbl.entities.Student;
import com.sbl.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Student addStudent(Student student) {
		Student newStudent = studentRepository.save(student);
		return newStudent;
	}

	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
	}

	public Student getSingleStudent(int id) {
		Student student = studentRepository.findById(id).get();
		return student;
	}
	
	public Student updateSingleStudent(int id,Student studentbody) {
		   Student student = studentRepository.findById(id).get();
		   student.setName(studentbody.getName());
		   student.setPercentage(studentbody.getPercentage());
		   student.setRollNo(studentbody.getRollNo());
		   student.setBranch(studentbody.getBranch());
		   studentRepository.save(student);
		   return student;
		}
	
	public String deleteStudent(int id) {
		Student student = studentRepository.findById(id).get();
		studentRepository.delete(student);
		return "Successfully Delete";
	}
}
