/*
StudentService.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package service;

import domain.Student;
import org.springframework.stereotype.Service;
import repository.IStudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService{


    //Implement singleton
    private final IStudentRepository repository;
    private static StudentService SERVICE;

    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student save(Student student) {
        return this.repository.save(student);
    }

    //Changed .read(s) to .findById(s)
    @Override
    public Optional<Student> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Student student) {
        this.repository.delete(student);
    }


    @Override
    public List<Student> findAll() {
        return null;
    }

}
