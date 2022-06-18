/*Jesse Merold Hiebner
EmployeeAddressRepository.java
creating Employee Address Repo using jpa
* */

package repository;

import domain.EmployeeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress,String>
{
    Optional<EmployeeAddress> read(String s);
    //All CRUD database methods

}
