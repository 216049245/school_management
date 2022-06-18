/* City.java Entity using builder pattern
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//@NoArgsConstructor
@AllArgsConstructor
@Table(name="city")
@Entity
public class City {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String cityId;

    @Column(name="cityName")
    private  String name;

    @Column(name="cityName")
    private  Country country;

    @OneToMany
    @JoinColumn(name="countryId")
    Country countryObject;

    private City(){}

    private City(Builder builder){
        this.cityId = builder.cityId;
        this.name = builder.name;
        this.country = builder.country;

    }

    public String getId() {
        return cityId;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public static class Builder{
        private String cityId;
        private String name;
        private Country country;

        public Builder cityId(String cityId){
            this.cityId = cityId;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder country(Country country){
            this.country = country;
            return this;
        }

        public Builder copy(City city){
            this.cityId = city.cityId;
            this.name = city.name;
            this.country = city.country;
            return this;
        }

        public City build(){return new City(this);}
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + cityId + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
