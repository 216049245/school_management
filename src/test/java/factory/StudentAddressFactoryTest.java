/*
StudentAddressFactoryTest.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package factory;


import domain.Address;
import domain.City;
import domain.Country;
import domain.StudentAddress;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StudentAddressFactoryTest {

    @Test
    public  void buildWithoutError() {
        Country country = CountryFactory.createCountryFactory("567", "England");
        City city = CityFactory.createCityFactory("465", "Liverpool", country);
        Address address = AddressFactory.createAddress("17","TownHouse","34","Blackpool", 7946, city);

        StudentAddress studentAddress = StudentAddressFactory.build("123456789", address );
        System.out.println(studentAddress);
        assertNotNull(studentAddress);

    }

    @Test
    public void buildWithError() {
        Country country = CountryFactory.createCountryFactory("567", "England");
        City city = CityFactory.createCityFactory("465", "Liverpool", country);
        Address address = AddressFactory.createAddress("17","TownHouse","34","Blackpool", 7946, city);

        Exception exception =  assertThrows(IllegalArgumentException.class, () ->
                StudentAddressFactory.build(null, address));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Student ID is required!", exceptionMessage);


    }


}