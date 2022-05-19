package com.example.SprinBootJavaMail.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service //* Marks StudentService as a spring bean
public class StudentService {
  // Service layer is responsible for the business logic.
  // Student controller talks to the service layer to get data. Which talks to the model.
  // StudentRepository seems like the DAO

	private final StudentRepository studentRepository;

	@Autowired //Dependency injection for the student repo.
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

}
