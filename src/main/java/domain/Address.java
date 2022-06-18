package domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    String unitNumber, complexName, streetNumber, streetName;
    int postalCode;
    City city;

    public Address(String unitNumber, String complexName, String streetNumber, String streetName, int postalCode, City city){
        this.unitNumber = unitNumber;
        this.complexName = complexName;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Address(Builder builder){
        this.unitNumber = unitNumber;
        this.complexName = complexName;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;

    }


    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public static class Builder {

        String unitNumber, complexName, streetNumber, streetName;
        int postalCode;
        City city;

        public Builder setUnitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder setComplexName(String complexName) {
            this.complexName = complexName;
            return this;
        }

        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setCity(City city) {
            this.city = city;
            return this;
        }

        public Address build() {

            return new Address(this);
        }

        public Builder copy(Address a) {
            this.unitNumber = a.unitNumber;
            this.complexName = a.complexName;
            this.streetNumber = a.streetNumber;
            this.streetName = a.streetName;
            this.postalCode = a.postalCode;
            this.city = a.city;
            return this;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "unitNumber='" + unitNumber + '\'' +
                    ", complexName='" + complexName + '\'' +
                    ", streetNumber='" + streetNumber + '\'' +
                    ", streetName='" + streetName + '\'' +
                    ", postalCode=" + postalCode +
                    ", city=" + city +
                    '}';
        }
    }
}
