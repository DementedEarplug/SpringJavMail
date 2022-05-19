package com.example.SprinBootJavaMail.student;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity //Map student to db. Hibernate
@Table //
public class Student {
  // This will be our model
  @Id
  @SequenceGenerator(
    name="student_sequence",
    sequenceName="student_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy= GenerationType.SEQUENCE,
    generator = "student_sequence"
  )
  private long id;
  private String name;
  private Integer age;
  private LocalDate dob;
  private String email;

  public Student() {

  }

  public Student(String name, Integer age, LocalDate dob, String email) {
    this.name = name;
    this.age = age;
    this.dob = dob;
    this.email = email;
  }

  public Student(long id, String name, Integer age, LocalDate dob, String email) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.dob = dob;
    this.email = email;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Student [age=" + age + ", dob=" + dob + ", email=" + email + ", id=" + id + ", name=" + name + "]";
  }
}
