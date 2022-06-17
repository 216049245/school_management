/*
StudentFactoryTest.java
Author: Monehi Tuoane (219350744)
Date: 17 June 2022
*/

package factory;

import domain.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    @Test
    public void buildWithoutError() {
        Student student = StudentFactory.build("123456789", "student@mail", "Mr Stud");
        System.out.println(student);
        assertNotNull(student);

    }

    @Test
    public void buildWithError() {

        Exception exception =  assertThrows(IllegalArgumentException.class, () ->
                StudentFactory.build(null, "student@mail", "Mr Stud"));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Student ID is required!", exceptionMessage);


    }

}