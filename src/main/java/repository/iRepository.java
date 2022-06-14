package repository;

import java.util.Optional;

public interface iRepository<T, ID>
{
    T save(T t);
    Optional<T> read(ID id);
    void delete(T t);
}
