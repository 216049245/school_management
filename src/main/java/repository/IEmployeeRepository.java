/*
IEmployeeRepository.java
Author: Brandon Lee Kruger (216049245)
Date: 18 June 2022
*/

package repository;

import domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee, String> {
    Optional<Employee> findEmployeeByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsById(String id);

}
