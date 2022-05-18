package com.example.SprinBootJavaMail.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service //* Marks StudentService as a spring bean
public class StudentService {
  // Service layer is responsible for the business logic.
  // Student controller talks to the service layer to get data. Which talks to the model.
  // Student seems like the DAO


	public List<Student> getStudents() {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Jojiba", 28, LocalDate.of(1994, 03, 13), "jjb@mail.com"));
		studentList.add(new Student("Karuga", 28, LocalDate.of(1994, 02, 24), "kirino@mail.com"));
		studentList.add(new Student("Helmoje", 24, LocalDate.of(1998, 12, 15), "Mayonais@mail.com"));
		return studentList;
	}

}
