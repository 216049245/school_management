/*
StudentAddressService.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/
package service.Impl;



import domain.StudentAddress;
import org.springframework.stereotype.Service;
import repository.IStudentAddressRepository;
import service.IStudentAddressService;


import java.util.List;
import java.util.Optional;

@Service
public class StudentAddressService implements IStudentAddressService {

    private final IStudentAddressRepository repository;


    public StudentAddressService(IStudentAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress) {
        return this.repository.save(studentAddress);
    }

    //Changed .read(s) to .findById(s)
    @Override
    public Optional<StudentAddress> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public StudentAddress findById(String s) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<StudentAddress> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(StudentAddress studentAddress) {
        this.repository.delete(studentAddress);
    }

    @Override
    public void deleteById(String studentId) {
       Optional<StudentAddress> student = read(studentId);
        if (student.isPresent()) delete(student.get());
    }

}
