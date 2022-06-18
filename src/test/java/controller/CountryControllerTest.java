/* CountryControllerTest.java country controller tests
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package controller;

import domain.Country;
import domain.Name;
import domain.Student;
import factory.CountryFactory;
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
class CountryControllerTest {
    @LocalServerPort
    private int M;

    @Autowired
    private CountryController control;
    @Autowired
    private TestRestTemplate restTemplate;

    private Country country;
    private String Url;

    @BeforeEach
    void setUp() {
        assertNotNull(control);
        this.country = CountryFactory.createCountryFactory("65564","Uganda");
        this.Url = "http://localhost:" + this.M + "/SchoolManagement/country/";
    }

    @Order(1)
    @Test
    void save() {
        String url = Url + "save";
        System.out.println(url);

        ResponseEntity<Country> response = this.restTemplate
                .postForEntity(url, this.country, Country.class);
        System.out.println(response);

        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertNotNull(response.getBody())
                );

    }

    @Order(2)
    @Test
    void read() {
        String url = Url + "delete" + this.country.getId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }

    @Order(3)
    @Test
    void deleteById() {
        String url = Url + "findAll";
        System.out.println(url);

        ResponseEntity<Country[]> response = this.restTemplate.getForEntity(url, Country[].class);
        System.out.println(Arrays.asList(response.getBody()));

        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertEquals(1, response.getBody().length)
                );
    }

    @Order(4)
    @Test
    void findAll() {
        String url = Url + "delete" + this.country.getId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }
}