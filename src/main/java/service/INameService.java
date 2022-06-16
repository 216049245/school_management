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
    public T save(T t);

    public <ID> Optional<T> read(ID id);

    public Name delete(T t);

    Name create(T t);

    Name update(T t);

}
