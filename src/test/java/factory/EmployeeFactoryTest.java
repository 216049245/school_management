/*
EmployeeFactoryTest.java
Author: Brandon Kruger (216049245)
Date: 17 June 2022
*/

package factory;

        import domain.Employee;
        import domain.Name;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    public void buildWithoutError() {
        Name name = NameFactory.buildName("Ruth","Van","Wilder");
        Employee employee = EmployeeFactory.build("123456789", "staff@mail", name);
        System.out.println(employee);
        assertNotNull(employee);

    }

    @Test
    public void buildWithError() {
        Name name = NameFactory.buildName("Ruth","Van","Wilder");

        Exception exception =  assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.build(null, "staff@mail", name));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Staff ID is required!", exceptionMessage);


    }

}