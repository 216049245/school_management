/*
StudentAddressService.java
Author: Monehi Tuoane (219350744)
Date: 16 June 2022
*/

package service;

import domain.StudentAddress;
import repository.StudentAddressRepository;


import java.util.Optional;

public class StudentAddressService implements IStudentAddressService {

    //Implement singleton
    private final StudentAddressRepository repository;
    private static StudentAddressService SERVICE;

    private StudentAddressService () {
        this.repository = StudentAddressRepository.studentAddressRepository();
    }

    public static StudentAddressService getService() {
        if (SERVICE == null)
            SERVICE = new StudentAddressService();
        return SERVICE;
    }



    @Override
    public StudentAddress save(StudentAddress studentAddress) {
        return this.repository.save(studentAddress);
    }

    @Override
    public Optional<StudentAddress> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(StudentAddress studentAddress) {
        this.repository.delete(studentAddress);
    }
}
