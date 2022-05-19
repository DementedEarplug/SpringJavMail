package com.example.SprinBootJavaMail.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

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

	/**
	 * Fetch all students
	 * @return
	 */
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addStudent(Student student) {
		Optional<Student> fetchedStudent = studentRepository.findStudentByEmail(student.getEmail());
		System.out.println();
		if(fetchedStudent.isPresent()){
			System.out.println("Sorry there is already a student with that email.");
			throw new IllegalStateException("Email taken.");
		} else {
			studentRepository.save(student);
		}
  }

	public void removeStudent(Long id) {
		Optional<Student> fetchedStudent = studentRepository.findStudentById(id);
		//Another way to do it
		// Boolean fetchedStudent = studentRepository.existsById(id) // And check fetchedStudent
		System.out.println();
		if(fetchedStudent.isPresent()){
			studentRepository.deleteById(id);
		} else {
			System.out.println("Sorry thereno student with that id.");
			throw new IllegalStateException("No Student with that Id.");
		}
  }

	@Transactional
	public void updateStudent(Long id, String name, String email){
		Student student = studentRepository.getById(id);
		if(student!=null){
			//Check name update
			if(name!=null && name.length()>0 && !Objects.equals(student.getName(), name)){
				System.out.println("Name is being changed");
				student.setName(name);
				System.out.println("\n\n"+student);
			}

			//Check email update
			if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(), email)){
				student.setEmail(email);
			}
		}
	}

}
