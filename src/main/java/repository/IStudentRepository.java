/*
IStudentRepository.java
Author: Monehi Tuoane (219350744)
Date: 15 June 2022
*/

package repository;

import java.util.Optional;

public interface IStudentRepository<T, ID> {

    Optional<T> read(ID studentId);
    void delete(T t);

}
