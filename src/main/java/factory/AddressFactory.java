package factory;

import domain.Address;
import domain.City;

public class AddressFactory {
    public static Address createAddress(String unitNumber, String complexName, String streetNumber,
                                        String streetName, int postalCode, City city) {

        if (unitNumber == null || unitNumber.isEmpty()){
            throw new IllegalArgumentException("Unit Number is required");
        }

        if (complexName == null || complexName.isEmpty()){
            throw new IllegalArgumentException("Complex Name is required");
        }

        if (streetNumber == null || streetNumber.isEmpty()){
            throw new IllegalArgumentException("Street Number is required");
        }

        if (streetName == null || streetName.isEmpty()){
            throw new IllegalArgumentException("Street Name is required");
        }

        if (city == null){
            throw new IllegalArgumentException("City details are required");
        }

        return new Address.Builder().setUnitNumber(unitNumber)
                .setComplexName(complexName)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setPostalCode(postalCode)
                .setCity(city)
                .build();

    }
}
