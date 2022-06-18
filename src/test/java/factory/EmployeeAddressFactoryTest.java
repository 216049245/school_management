package factory;

import domain.Address;
import domain.City;
import domain.EmployeeAddress;
import org.junit.jupiter.api.Test;
import domain.Country;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest
{


    @Test
    public void buildWithSuccess()
    {
        Country country = CountryFactory.createCountryFactory("#56784","South Africa");
        City city = CityFactory.createCityFactory("7945","Cape Town",country);
        Address address = AddressFactory.createAddress("17","Vanguard","34","Odinson", 8767, city);
        EmployeeAddress employeeAddress = EmployeeAddressFactory
                .build("1ABCS", address);
        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }

    @Test
    public void buildWithError()
    {

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        EmployeeAddressFactory
                .build(null,null));

        String exceptionMessage = exception.getMessage();
        assertSame("Staff id is required!",exceptionMessage);
    }


}