package com.learningspringboot.student.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface studentsRepository extends JpaRepository<students,Long> {
    @Query("SELECT s FROM students s WHERE s.email=?1")
    Optional<students> findstudentsByEmail(String email);
}
