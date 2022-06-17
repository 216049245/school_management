package factory;

import domain.Address;
import domain.City;
import domain.Country;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void createAddress() {
    }

    @Test
    public void test() {
        Country country = CountryFactory.createCountryFactory("345", "Finland");
        City city = CityFactory.createCityFactory("776", "Helsinki", country);
        Address address = AddressFactory.createAddress("17","Vanguard","34","Odinson", 8767, city);
        System.out.println(address.toString());
        assertNotNull(address);
    }
}