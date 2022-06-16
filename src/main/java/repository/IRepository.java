package repository;

public interface IRepository<T,ID> {
    T create(T t);
    T read(T ID);
    T update(T t);
    void delete(ID id);
}
