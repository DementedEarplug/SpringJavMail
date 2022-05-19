package com.example.SprinBootJavaMail.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// On the JpaRepo extension you end up putting the type you are working with, and the datatype for
// its ID in the db
@Repository // Thi sinterface is responsible for data access.
public interface StudentRepository extends JpaRepository<Student, Long> {
  // This is the DAO here is where you talk to the DB
  // This setvice is used inside of the service class
}
