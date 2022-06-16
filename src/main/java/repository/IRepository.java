package repository;

import java.util.Optional;

public interface IRepository <T, ID>{

    T save(T t);
    T create(T t);
    T update(T t);
    Optional<T> read(ID id);
    void delete(T t);

}
