/* ICityInterface.java city interface
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package service;

import domain.City;

import java.util.Optional;

public interface ICityService extends IService<City, String> {
    Optional<City> findByCountryId(String countryId);
}
