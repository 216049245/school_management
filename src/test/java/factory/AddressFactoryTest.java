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

    @Test
    public void testWithError(){
        Country country = CountryFactory.createCountry("345", "Finland");
        City city = CityFactory.createCityFactory("776", "Helsinki", country);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> AddressFactory.createAddress(null, "Garm", "456", "Floki", 3456, city));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Unit Number is required", exceptionMessage);
    }
}