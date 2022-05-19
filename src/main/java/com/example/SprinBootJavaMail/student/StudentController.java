package com.example.SprinBootJavaMail.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Allows class to serve rests endpoints
@RequestMapping(path = "api/v1/student")
public class StudentController {
  // This class will have all of the resources for our api. MEaning this is where
  // we define the
  // endpoints. Endpoints will call the Service which will use the model to get
  // data.

  final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    // * This currently does not work you would need to use new StudentService().
    // * This is where Dejendency injection comes in! using @Autowired, howeve for
    // * autowired to work, you need to make StudenService a spring bean.

    this.studentService = studentService;
  }

  @GetMapping // Enables GET Requests
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

  @PostMapping //Enables POST Requests
  //Map request body to student
  public void addStudent(@RequestBody Student student) {
    studentService.addStudent(student);
  }

  @DeleteMapping(path = "{id}") //Enables DELETE Requests
  public void removeStudent(@PathVariable("id") Long id) {
    studentService.removeStudent(id);
  }
}
