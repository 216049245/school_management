/*
StudentServiceTest.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package service;

import domain.Name;
import domain.Student;
import factory.NameFactory;
import factory.StudentFactory;
import org.junit.jupiter.api.Order;
import service.StudentService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceTest {

    private final Name name = NameFactory.buildName("name", "middle-name", "last-name");
    private final Student student = StudentFactory.build("101010", "test@gmail.com", name);
   // public Student.StudentId studentId = StudentFactory.buildId(this.student);

    //@Autowired
    private StudentService service;

    @Order(1)
    @Test
    void save() {
        Student saved = this.service.save(this.student.getStudentId());
        System.out.println(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.student.getStudentId(),saved)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Student> read = this.service.read((this.student.getStudentId()));
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.student.getStudentId(), read.get())
        );
    }


    @Order(3)
    @Test
    void findByStudentId() {
        //String studentId = this.studentId.getStudentId();
        //List<Student> studentList = this.service.findByStudentId(studentId);
        //System.out.println(studentList);
        //assertSame(1,studentList.size());
    }

    @Order(4)
    @Test
    void delete() {
        this.service.delete(this.student.getStudentId());
        List<Student> studentList = this.service.findAll();
        assertEquals(0, studentList.size());

    }


    @Order(5)
    @Test
    void findAll() {
        List<Student> studentList = this.service.findAll();
        System.out.println(studentList);
        assertEquals(1, studentList.size());
    }


    @Test
    void deleteById() {
    }



}