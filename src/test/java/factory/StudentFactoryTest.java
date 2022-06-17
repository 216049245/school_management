package factory;

import domain.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentFactoryTest {

    @Test
    public void build() {
        Student student = StudentFactory.build("", "", "");
        System.out.println(student);
        assertNotNull(student);

    }

}