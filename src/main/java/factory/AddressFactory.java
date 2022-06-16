package factory;

import domain.Address;
import domain.City;

public class AddressFactory {
    public static Address createAddress(String unitNumber, String complexName, String streetNumber,
                                        String streetName, int postalCode, City city) {

        return new Address.Builder().setUnitNumber(unitNumber)
                .setComplexName(complexName)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setPostalCode(postalCode)
                .setCity(city)
                .build();

    }
}
