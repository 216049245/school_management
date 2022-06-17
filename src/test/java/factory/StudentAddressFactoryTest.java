package factory;

import domain.Student;
import domain.StudentAddress;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class StudentAddressFactoryTest {

    @Test
    public  void build() {

        StudentAddress studentAddress = StudentAddressFactory.build("", "");
        System.out.println(studentAddress);
        assertNotNull(studentAddress);

    }

}