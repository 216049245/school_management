/*
StudentAddressFactoryTest.java
Author: Monehi Tuoane (219350744)
Date: 17 June 2022
*/

package factory;


import domain.StudentAddress;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StudentAddressFactoryTest {

    @Test
    public  void buildWithoutError() {

        StudentAddress studentAddress = StudentAddressFactory.build("123456789", "Cape Town");
        System.out.println(studentAddress);
        assertNotNull(studentAddress);

    }

    @Test
    public void buildWithError() {

        Exception exception =  assertThrows(IllegalArgumentException.class, () ->
                StudentAddressFactory.build(null, "Cape Town"));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Student ID is required!", exceptionMessage);


    }


}