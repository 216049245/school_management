package service;

import domain.Student;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService implements IStudentService{


    //Implement singleton
    private final StudentRepository repository;
    private static StudentService SERVICE;

    private StudentService () {
        this.repository = StudentRepository.studentRepository();
    }

    public static StudentService getService() {
        if (SERVICE == null)
            SERVICE = new StudentService();
        return SERVICE;
    }

    @Override
    public Student save(Student student) {
        return this.repository.save(student);
    }

    @Override
    public Optional<Student> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(Student student) {
        this.repository.delete(student);
    }
}
