package factory;

import domain.Name;
import org.junit.jupiter.api.*;
import service.NameServiceImpl;

/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {

    @Test
    //testing to see whether the name input equals the name on the system
    public void createFirstNames(){
         Name nam = NameFactory.buildName("Siphiwe","Edson","Chauque");
        System.out.println("Name on the system is: "+nam.getFirstName());
        assertEquals("Siphiwe",nam.getFirstName());
    }

    @Test
    //testing to see what happens when a user doesn't input all the required information. *Test should fail
    public void createMiddleName(){
        Name nam = NameFactory.buildName("Siphiwe", null, "Chauque");
        assertNull(nam.getMiddleName());
    }


    @Test
    // testing to see if the Lastname is the same as the one in the system
    public void createLastName(){
        Name nam = NameFactory.buildName("Siphiwe","Edson","Chauque");
        System.out.println("Lastname on the system is: "+nam.getLastName());
        assertSame("Chauque",nam.getLastName());
    }

    @Disabled("CreateName disabled")
    @Test
    //We disabling the test
    public void createName(){
        Name nam = (Name) NameServiceImpl.getService().getAll();
        assertSame("Siphiwe",nam.getFirstName());
    }


}