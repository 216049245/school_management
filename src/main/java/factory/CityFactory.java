/* CityFactory.java Entity using Factory pattern
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package factory;

import domain.City;
import domain.Country;


public class CityFactory {

    public static City createCityFactory(String id, String name, Country country) {

        City city =  new City.Builder().id(id)
                .name(name)
                .country(country)
                .build();
        return city;
    }
}
