package service;

import domain.Name;

import java.util.Optional;

/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */

public interface INameService<T, ID> {
    T save(T t);

    <ID> Optional<T> read(ID id);

    Name delete(T t);

    Name create(T t);

    Name update(T t);

}
