/* Country.java Entity using builder pattern
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="country")
public class Country {

    @Id @NotNull @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  String countryId;

    @Column(name="countryName")
    private  String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<City> city;


    private Country(){}

    private Country(Builder builder){
        this.countryId = builder.countryId;
        this.name = builder.name;

    }

    public String getId() {
        return countryId;
    }

    public String getName() {
        return name;
    }
    
    public static class Builder{
        private String countryId;
        private String name;

        public Builder countryId(String id){
            this.countryId = countryId;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder copy(Country country){
            this.countryId = country.countryId;
            this.name = country.name;
            return this;
        }

        public Country builder(){return new Country(this);}
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + countryId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
