package factory;

import domain.Address;
import domain.EmployeeAddress;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest
{

    @Test
    public void buildWithSuccess()
    {
        EmployeeAddress employeeAddress = EmployeeAddressFactory
                .build("1ABCS",null);
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