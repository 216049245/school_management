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
public class StudentRepository implements IStudentRepository<Student, String>{

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

    //Create and Update into Save
    public Student save(Student student) {
        //Update
        Optional<Student> read = read(student.getStudentId());
        if (read.isPresent()) {
            delete(read.get());
        }
        //Create
        this.studentList.add(student);
        return  student;
    }

    //Read
    //"Optional <method>..." prevents a return of null
    public Optional<Student> read(String studentId) {
        //find student that matches the student id and return
        return this.studentList.stream().filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                .findAny();

    }



    //Delete
    @Override
    public void delete(Student student) {
        this.studentList.remove(student);

    }

    //Find All
    public List<Student> findAll() {
        //returns all the stored students
        return this.studentList;
    }


}
