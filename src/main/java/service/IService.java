package service;

import java.util.*;


public interface IService <T, ID> {
    T create(T t);
    List<T> findAll();
    T findById(ID id);
    void delete(ID id);

}
