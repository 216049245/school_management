/* CountryFactory.java Entity using Factory pattern
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package factory;


import domain.Country;

public class CountryFactory {

    public static Country createCountryFactory(String countryId, String name) {
        if(countryId.isEmpty() || countryId ==null)
            throw new IllegalArgumentException("Country id is required!");
        if(name.isEmpty() || name ==null)
            throw new IllegalArgumentException("The name of the country is required!");

        return new Country.Builder().countryId(countryId).name(name).builder();

    }

}
