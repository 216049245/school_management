/*
StudentAddressControllerTest.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package controller;

import domain.Address;
import domain.Name;
import domain.Student;
import domain.StudentAddress;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import service.IStudentService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentAddressController Controller;
    @Autowired private TestRestTemplate restTemplate;

    @Autowired private IStudentService iStudentService;
    private StudentAddress studentAddress;
    private Address address;
    private String baseUrl;

    private Student student;
    private Name name;


    //SAVING
    @Order(1)
    @Test
    void save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<StudentAddress> response = this.restTemplate
                .postForEntity(url, this.studentAddress, StudentAddress.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK,response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    //READING
    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "read/" + this.studentAddress.getStudentId();
        System.out.println(url);
        ResponseEntity<StudentAddress> response = this.restTemplate.getForEntity(url, StudentAddress.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }


    //DELETING
    @Order(3)
    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.studentAddress.getStudentId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    //READING or FINDING ALL
    @Order(4)
    @Test
    void findAll() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<StudentAddress[]> response =
                this.restTemplate.getForEntity(url, StudentAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(0, response.getBody().length)
        );
    }

    @Order(5)
    @Test
    void findStudentsInCountry() {
        String url = baseUrl + "read-last-name-by-country-id/" + studentAddress.getAddress().getCity().getCountry().getCountryId();
        System.out.println(url);
        ResponseEntity<String[]> response = this.restTemplate.getForEntity(url, String[].class);
        System.out.println(response.getBody());
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertEquals(1, response.getBody().length)
        );
    }
}