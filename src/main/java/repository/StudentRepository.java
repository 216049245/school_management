/*
StudentRepository.java
Author: Monehi Tuoane (219350744)
Date: 15 June 2022
*/

package repository;

import domain.Student;

import java.util.List;

//CRUD
public class StudentRepository {

    public Student create(Student student) {
        //save and return if successful
        return  student;
    }

    public Student read(String studentId) {
        //find student that matches the id and return
        return null;
    }

    public Student  update(Student student) {
        //check if student exists, if yes update and return if successful
        return student;
    }

    public void delete(String studentId) {
        //finds the student if required and delete
    }

    public List<Student> findAll() {
        //returns all the stored students
        return null;
    }


}
