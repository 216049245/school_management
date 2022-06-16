/* CountryFactory.java Entity using Factory pattern
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package factory;


import domain.Country;

public class CountryFactory {

    public static Country createCountry(String id, String name) {

        Country country =  new Country.Builder().id(id)
                .name(name)
                .build();
        return country;
    }
}
