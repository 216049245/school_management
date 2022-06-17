package factory;

import domain.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */
class NameFactoryTest {
        @Test
        void nameNull() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                NameFactory.buildName("Siphiwe", null, "Chauque");

            });
            String expectedMessage = "Invalid value for param:";
            String actualMessage = exception.getMessage();
            assertFalse(actualMessage.contains(expectedMessage));
        }

        @Test
        void nameBuild() {
            Name name1 = NameFactory.buildName("Siphiwe", "Edson", "Chauque");
            System.out.println(name1);
            assertNotNull(name1);
        }
    }