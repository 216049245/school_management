package service;

import domain.Name;
import factory.NameFactory;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import repository.NameRepositoryImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */


class NameServiceImplTest {
    private final static Name name1 = NameFactory.buildName("Siphiwe", "Edson", "Chauque");
    private final NameService service = NameServiceImpl.getService();

    @Before("6")
    public void setUp() {
        System.out.println("Name: " + name1);
    }


    @Test
    public void b_read() {
        NameRepositoryImpl repo = new NameRepositoryImpl();
        Name testName = new Name.Builder().firstName(name1.getFirstName()).build();
        Assertions.assertNotNull(repo.read(testName));
    }


    @Disabled("CreateName disabled")
    @Test
    //We disabling the test
    public void createName(){
        Name nam = NameFactory.buildName("Siphiwe","Edson","Chauque");
        assertSame("Siphiwe",nam.getFirstName());
    }
    @Test
    public void a_create() {
        Name inserted = service.create(name1);
        assertEquals(inserted.getFirstName(), name1.getFirstName());
        System.out.println("Inserted: " + inserted);
    }

    @Test
    public void e_delete() {
        service.delete(name1.getMiddleName());
    }

}

