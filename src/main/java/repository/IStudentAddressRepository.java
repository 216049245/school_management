/*
IStudentAddressRepository.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/
package repository;

import domain.StudentAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentAddressRepository extends JpaRepository<StudentAddress, String> {

}
