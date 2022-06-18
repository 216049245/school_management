/*
IStudentAddressService.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package service;


import domain.StudentAddress;

import java.util.List;

public interface IStudentAddressService extends IService<StudentAddress, String> {
    StudentAddress save(StudentAddress studentAddress);

    List<StudentAddress> findAll();
    //void delete(StudentAddress studentAddress);
    void deleteById(String studentId);
}

