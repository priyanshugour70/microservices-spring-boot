package com.gour.priyanshu.service;

import com.gour.priyanshu.exception.StudentNotFoundException;
import com.gour.priyanshu.model.Student;
import com.gour.priyanshu.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepo repo;

    @Override
    public Integer saveStudent(Student s) {
        s = repo.save(s);
        return s.getStdId();
    }

    @Override
    public void updateStudent(Student s) {

        //check whether object exists with that id
        if(s.getStdId() == null || !repo.existsById(s.getStdId()))
            throw new StudentNotFoundException("STUDENT '"+s.getStdId()+"' NOT EXIST");
        else
            //if id exists then perform update
            repo.save(s);
    }

    @Override
    public void deleteStudent(Integer id) {
        repo.delete(getOneStudent(id));

    }

    @Override
    public Student getOneStudent(Integer id) {
        return repo.findById(id)
                .orElseThrow(
                        ()->new StudentNotFoundException("STUDENT '"+id+"' NOT EXIST")
                );
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

}