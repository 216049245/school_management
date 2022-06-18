package service;

import domain.Student;

import java.util.*;


public interface IService <T, ID> {
    T save(T t);
    List<T> findAll();
    Optional<T> read(ID id);
    T findById(ID id);
    void delete(ID id);

}
