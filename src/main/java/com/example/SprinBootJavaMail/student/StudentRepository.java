package com.example.SprinBootJavaMail.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// On the JpaRepo extension you end up putting the type you are working with, and the datatype for
// its ID in the db
@Repository // Thi sinterface is responsible for data access.
public interface StudentRepository extends JpaRepository<Student, Long> {
  // This is the DAO here is where you talk to the DB
  // This setvice is used inside of the service class

  //Custom logic to intercat with db

  //Another way to do this, that can give you some fine tuning is with @qury anotation
  // @Query("SELECT s FROM Student s WHERE s.email =?1") //* This is JPQL syntax
  Optional<Student> findStudentByEmail(String email); //Optionals are helpful to check nul or not

  Optional<Student> findStudentById(Long id); //Optionals are helpful to check nul or not

}
