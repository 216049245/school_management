/*
StudentControllerTest.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/
package controller;

import domain.Name;
import domain.Student;
import factory.NameFactory;
import factory.StudentFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {

    @LocalServerPort
    private int M;

    @Autowired
    private StudentController control;
    @Autowired
    private TestRestTemplate restTemplate;

    private Name name;
    private Student student;
    private String Url;

    @BeforeEach
    void setUp() {
        assertNotNull(control);
        this.name = NameFactory.buildName("Mona", "", "Lisa");
        this.student = StudentFactory.build("mona123", "momo@mail.com", name);
        this.Url = "http://localhost:" + this.M + "/SchoolManagement/student/";
    }


    @Order(1)
    @Test
    //SAVING
    void save() {
        String url = Url + "save";
        System.out.println(url);

        ResponseEntity<Student> response = this.restTemplate
                .postForEntity(url, this.student, Student.class);
        System.out.println(response);

        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertNotNull(response.getBody())
                );
    }

    @Order(2)
    @Test
    //READING
    void read() {
        String url = Url + "delete" + this.student.getStudentId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(3)
    @Test
    //DELETING
    void deleteById() {
        String url = Url + "findAll";
        System.out.println(url);

        ResponseEntity<Student[]> response = this.restTemplate.getForEntity(url, Student[].class);
        System.out.println(Arrays.asList(response.getBody()));

        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertEquals(1, response.getBody().length)
                );
    }

    @Order(4)
    @Test
    //READING or FINDING ALL
    void findAll() {
        String url = Url + "delete" + this.student.getStudentId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }
}