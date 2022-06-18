/* CityFactory.java Entity using Factory pattern
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package factory;

import domain.City;
import domain.Country;


public class CityFactory {

    public static City createCityFactory(String cityId, String name, Country country) {
        if(cityId == null )
            throw new IllegalArgumentException("A city id is required!");
        if(name == null)
            throw new IllegalArgumentException("The name of the city is required!");


        return new City.Builder().cityId(cityId).name(name).country(country).build();

    }
}
