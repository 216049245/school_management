/* ICountryInterface.java country interface
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package service;

import domain.Country;

import java.util.Optional;

public interface ICountryService extends IService<Country, String>{
    Optional<Country> findByCountryId(String countryId);
}
