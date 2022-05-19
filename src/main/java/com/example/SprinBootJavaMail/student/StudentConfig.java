package com.example.SprinBootJavaMail.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StudentConfig {
  //Seed data

  @Bean
  //? How is the student repo injected without autowire??
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    return args -> {
      List<Student> studenList = new ArrayList<> ();
      studenList.add(new Student("Jojiba", LocalDate.of(1995, 03, 13), "jjb@mil.com"));
      studenList.add(new Student("Karuga", LocalDate.of(1994, 02, 24), "kirino@mail.com"));
      studenList.add(new Student("Helmoje", LocalDate.of(1998, 12, 15), "Mayonais@mail.com"));
      //On Java 11 you can do List.of.
      repository.saveAll(studenList);
    };
  }
}
