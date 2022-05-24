package com.example.SprinBootJavaMail.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentWebController {

  @Autowired
  StudentController studentController;

  @GetMapping("/")
  public String getStudents(Model model){
    List<Student> students = studentController.getStudents();
    model.addAttribute("students", students);
    return "show-students";
  }

  @GetMapping("/add-student")
  public String addStudent(Model model){
    Student student = new Student();
    model.addAttribute("newStudent", student);
    return "add-student";
  }

  @PostMapping(path = "/save")
  public String save(@ModelAttribute Student student ){
    studentController.addStudent(student);
    return "redirect:/";
  }

  @GetMapping(path = "/edit-student/{id}")
  public String editStudent(@PathVariable("id") Long id, Model model){
    Student student = studentController.getStudentById(id);
    model.addAttribute("newStudent", student);
    return "edit-student";
  }

  @PostMapping(path = "/save-update")
  public String update(@ModelAttribute Student student ){
    studentController.updateStudent(student.getId(), student);
    return "redirect:/";
  }

  @GetMapping(path = "/delete-student/{id}")
  public String deleteStudent(@PathVariable("id") Long id, Model model){
    Student student = studentController.getStudentById(id);
    model.addAttribute("newStudent", student);
    return "delete-student";
  }

  @PostMapping(path = "/delete")
  public String delete(@ModelAttribute Student student ){
    studentController.removeStudent(student.getId());
    return "redirect:/";
  }

}
