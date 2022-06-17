package factory;

import domain.City;
import domain.Country;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {

    @Test
    public void buildWithoutError() {
        Country country = CountryFactory.createCountryFactory("#56784","South Africa");
        City city = CityFactory.createCityFactory("7945","Cape Town",country);
        System.out.println(city.toString());
        assertNotNull(city);

    }

    /*@Test
    public void buildWithError() {

        Exception exception =  assertThrows(IllegalArgumentException.class, () ->
               CityFactory.createCityFactory(null, "Cape Town", null));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("City ID is required!", exceptionMessage);


    }*/
}