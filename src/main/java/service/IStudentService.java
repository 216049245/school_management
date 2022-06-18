/*
IStudentServic.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package service;

import domain.Student;

import java.util.List;

public interface IStudentService extends IService<Student, String> {
    List<Student> findAll();

}
