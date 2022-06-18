/*
StudentService.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package service.Impl;

import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IStudentRepository;
import service.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepository repository;


    @Autowired
    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student findById(String s) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Optional<Student> read(String s) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String id) {

    }
}