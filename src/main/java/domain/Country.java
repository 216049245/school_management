/* Country.java Entity using builder pattern
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package domain;
//@Entity
//@Table(name="Country")
public class Country {

    private final String id;
    private final String name;
    //private final set<City> city;

    private Country(Builder builder){
        this.id = builder.id;
        this.name = builder.name;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public static class Builder{
        private String id;
        private String name;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder copy(Country country){
            this.id = country.id;
            this.name = country.name;
            return this;
        }

        public Country build(){return new Country(this);}
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
