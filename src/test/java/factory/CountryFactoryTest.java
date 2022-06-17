package factory;

import domain.Country;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {

    @Test
    public void buildWithoutError() {
        Country country = CountryFactory.createCountryFactory("#56784","South Africa");
        System.out.println(country.toString());
        assertNotNull(country);

    }

    @Test
    public void buildWithError() {

        Exception exception =  assertThrows(IllegalArgumentException.class, () ->
                CountryFactory.createCountryFactory(null, "Cape Town"));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Country ID is required!", exceptionMessage);

    }


}