package repository;

import domain.Name;

import java.util.Optional;

/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */

public interface iNameRepository<T> {
     <ID> Optional<T> read(ID id);
     NameRepository delete(Name t);
     Optional<Name> read(String identity);
}
