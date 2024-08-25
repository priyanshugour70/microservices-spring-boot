package com.gour.priyanshu.service;

import com.gour.priyanshu.model.Student;

import java.util.List;

public interface IStudentService {

    /*
     * Input  : Student object
     * Output : PK value of the student object
     */
    Integer saveStudent(Student s);

    /*
     * Input  : Student object
     * Output : No return type
     */
    void updateStudent(Student s);

    /*
     * Input  : Id of the student
     * Output : No return type
     */
    void deleteStudent(Integer id);

    /*
     * Input  : Id of the student
     * Output : Student Object if present otherwise null
     */
    Student getOneStudent(Integer id);

    /*
     * Input  : no input
     * Output : List<Student> object
     */
    List<Student> getAllStudents();


}