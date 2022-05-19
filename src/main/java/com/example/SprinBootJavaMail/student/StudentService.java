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
		// (new Student("Jojiba", 28, LocalDate.of(1994, 03, 13), "jjb@mil.com"));
		// (new Student("Karuga", 28, LocalDate.of(1994, 02, 24), "kirino@mail.com"));
		// (new Student("Helmoje", 24, LocalDate.of(1998, 12, 15), "Mayonais@mail.com"));
		return studentRepository.findAll();
	}

}
