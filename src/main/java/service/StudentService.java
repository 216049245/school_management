/*
StudentService.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package service;

import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IStudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepository repository;


    @Autowired
    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }


    public Student save(Student studentId) {
        return this.repository.save(studentId);
    }


    public Optional<Student> read(Student student) {
        return Optional.empty();
    }


    public Optional<Student> read(String studentId) {
        return this.repository.findById(studentId);
    }

    //@Override
    public void delete(Student student) {
        this.repository.delete(student);
    }

    @Override
    public void deleteById(String studentId) {
        Optional<Student> student = read(studentId);
        if (student.isPresent()) delete(student.get());
    }




    @Override
    public Student create(Student student) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(String s) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

}