package service;

import domain.Student;
import org.springframework.stereotype.Service;
import repository.IStudentRepository;

import java.util.Optional;

@Service
public class StudentService implements IStudentService{


    //Implement singleton
    private final IStudentRepository repository;
    private static StudentService SERVICE;

    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    /*
    private StudentService () {
        this.repository = StudentRepository.studentRepository();
    }

    public static StudentService getService() {
        if (SERVICE == null)
            SERVICE = new StudentService();
        return SERVICE;
    }

     */

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
}
