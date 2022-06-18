/*
StudentServiceTest.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package service;

import domain.Name;
import domain.Student;
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

    private final Student student = StudentFactory.build("123",
            "FREDDY@MAIL.COM", new Name());
   // public Student.StudentId studentId = StudentFactory.buildId(this.student);

    @Autowired
    //public StudentService service;


    @Test
    @Order(1)
    void save() {
        //Student student = this.service.save(this.student);
        assertAll(
                () -> assertNotNull(student),
                () -> assertEquals(this.student,student)
        );
    }

    @Test
    @Order(2)
    void read() {
        //Optional<Student> read = this.service.read(this.studentId);
        //System.out.println(read);
        //assertAll(()->assertTrue(read.isPresent()),()->assertEquals(this.student,read.get()));
    }


    @Test
    @Order(3)
    void findByStudentId() {
        //String studentId = this.studentId.getStudentId();
        //List<Student> studentList = this.service.findByStudentId(studentId);
        //System.out.println(studentList);
        //assertSame(1,studentList.size());
    }

    @Test
    @Order(4)
    void delete() {
        //this.service.delete(this.student);

    }

    @Test
    @Order(5)
    void findAll() {
        //List<Student>  studentList = this.service.findAll();
        //assertEquals(0,studentList.size());
    }


    @Test
    void deleteById() {
    }



}