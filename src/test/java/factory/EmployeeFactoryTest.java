/*
EmployeeFactoryTest.java
Author: Brandon Kruger (216049245)
Date: 17 June 2022
*/

package factory;

        import domain.Employee;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    public void buildWithoutError() {
        Employee employee = EmployeeFactory.build("123456789", "staff@mail", "Mrs Potato Head");
        System.out.println(employee);
        assertNotNull(employee);

    }

    @Test
    public void buildWithError() {

        Exception exception =  assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.build(null, "staff@mail", "Mrs Potato Head"));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Staff ID is required!", exceptionMessage);


    }

}