/* ICityRepository.java
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package repository;

import domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City, String> {

}
