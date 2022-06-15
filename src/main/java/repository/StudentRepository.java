/*
StudentRepository.java
Author: Monehi Tuoane (219350744)
Date: 15 June 2022
*/

package repository;

import domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//CRUD
public class StudentRepository {

    //Implement singleton
    private final List<Student> studentList;
    private static StudentRepository STUDENT_REPO;

    private StudentRepository () {
        this.studentList = new ArrayList<>();
    }

    public static StudentRepository studentRepository() {
        if (STUDENT_REPO == null)
            STUDENT_REPO = new StudentRepository();
        return STUDENT_REPO;
    }


    public Student create(Student student) {
        this.studentList.add(student);
        return  student;
    }

    //"Optional <method>..." prevents a return of null
    public Optional<Student> read(String studentId) {
        //find student that matches the student id and return
        return this.studentList.stream().filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                .findAny();

    }

    public Student  update(Student student) {
        //check if student exists, if yes update and return if successful
        Optional<Student> read = read(student.getStudentId());
        if (read.isPresent()) {
            delete(String.valueOf(read.get()));
            create(student);
        }
        return student;
    }

    public void delete(String studentId) {
        //finds the student if required and delete
        this.studentList.remove(studentId);
    }

    public List<Student> findAll() {
        //returns all the stored students
        return this.studentList;
    }


}
