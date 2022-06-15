/*
IStudentRepository.java
Author: Monehi Tuoane (219350744)
Date: 15 June 2022
*/

package repository;

import domain.Student;

import java.util.List;

public interface IStudentRepository<S, S1> extends IRepository<Student, String> {

    List<Student> findAll();


}
