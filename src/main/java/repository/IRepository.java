package repository;

public interface IRepository<T,ID> {
    T create(T t);
    T read(T ID);
    T update(T t);
    boolean delete(ID id);
}
