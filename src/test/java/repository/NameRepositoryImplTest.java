package repository;

import domain.Name;
import factory.NameFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */
class NameRepositoryImplTest {
    final static NameRepositoryImpl NameRepo = (NameRepositoryImpl) NameRepositoryImpl.getRepository();
    private final static Name name = NameFactory.buildName("Vusi","Jerson", "Chauque");


    @Test
    void a_create() {
        Name NameCreated = NameRepo.create(name);
        assertEquals(name.getFirstName(), NameCreated.getFirstName());
        System.out.println("Created: " + NameCreated);
    }

    @Test
    public void b_read() {
        NameRepositoryImpl repo = new NameRepositoryImpl();
        Name testName = new Name.Builder().firstName(name.getFirstName()).build();
        Assertions.assertNotNull(repo.read(testName));
    }


    @Test
    void c_delete() {
        boolean outcome = NameRepo.delete(name.getFirstName());
        assertFalse(outcome);
        System.out.println("Deleted: " + true);
            }


    @Test
    void d_getAll() {
        System.out.println("Display All: ");
        System.out.println(NameRepo.getAll());
        System.out.println(name);
    }
}