/*
StudentAddressService.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/
package service;


import domain.StudentAddress;
import org.springframework.stereotype.Service;
import repository.IStudentAddressRepository;


import java.util.Optional;

@Service
public class StudentAddressService implements IStudentAddressService{

    //Implement singleton
    private final IStudentAddressRepository repository;
    private static StudentAddressService SERVICE;

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
    public void delete(StudentAddress studentAddress) {
        this.repository.delete(studentAddress);
    }

}
