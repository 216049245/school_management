package service;

import domain.Name;

import java.util.Optional;
import java.util.Set;

/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */
public interface NameService extends INameService<Name, String> {


    Optional<Name> read(String s);

    Set<Name> getAll();

    Name delete(String s);

    Set<Name> getall();

    Set<Name> getWithLastName(String lastName);
}
