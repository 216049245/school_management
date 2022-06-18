/* CityControllerTest.java JPA controller test
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */

package controller;

import domain.City;
import domain.Country;
import domain.Name;
import domain.Student;
import factory.CityFactory;
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
class CityControllerTest {

    @LocalServerPort
    private int M;

    @Autowired
    private CityController control;
    @Autowired
    private TestRestTemplate restTemplate;

    private City city;
    private Country country;
    private String Url;

    @BeforeEach
    void setUp() {
        assertNotNull(control);
         this.country = CountryFactory.createCountryFactory("34243","Uganda");
         this.city = CityFactory.createCityFactory("342","booboo",country);
        this.Url = "http://localhost:" + this.M + "/SchoolManagement/city/";
    }

    @Order(1)
    @Test
    void save() {
        String url = Url + "save";
        System.out.println(url);

        ResponseEntity<City> response = this.restTemplate
                .postForEntity(url, this.city, City.class);
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
        String url = Url + "delete" + this.city.getId();
        System.out.println(url);
        this.restTemplate.delete(url);

    }

    @Order(3)
    @Test
    void deleteById() {
        String url = Url + "findAll";
        System.out.println(url);

        ResponseEntity<City[]> response = this.restTemplate.getForEntity(url, City[].class);
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
        String url = Url + "delete" + this.city.getId();
        System.out.println(url);
        this.restTemplate.delete(url);
    }
}