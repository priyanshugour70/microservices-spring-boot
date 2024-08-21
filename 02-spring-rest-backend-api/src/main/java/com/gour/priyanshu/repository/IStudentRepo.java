package com.gour.priyanshu.repository;

import com.gour.priyanshu.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

}