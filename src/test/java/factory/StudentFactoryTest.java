/*
StudentFactoryTest.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package factory;

import domain.Name;
import domain.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    @Test
    public void buildWithoutError() {
        Student student = StudentFactory.build("123456789", "student@mail", new Name());
        System.out.println(student);
        assertNotNull(student);

    }

    @Test
    public void buildWithError() {

        Exception exception =  assertThrows(IllegalArgumentException.class, () ->
                StudentFactory.build(null, "student@mail", new Name()));

        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Student ID is required!", exceptionMessage);


    }

}