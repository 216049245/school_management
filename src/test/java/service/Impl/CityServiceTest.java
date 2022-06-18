/* CityServiceTest.java city service tests
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package service.Impl;

import domain.City;
import domain.Country;
import factory.CityFactory;
import factory.CountryFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityServiceTest {

    private final Country country = CountryFactory.createCountryFactory("56756","South Africa");
    private final City city = CityFactory.createCityFactory("","",country);

    @Test
    void save() {
    }

    @Test
    void findAll() {
    }

    @Test
    void read() {
    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByCountryId() {
    }
}