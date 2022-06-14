/* City.java Entity using builder pattern
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package domain;

public class City {
    private final String id;
    private final String name;
    private final Country country;

    private City(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.country = builder.country;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public static class Builder{
        private String id;
        private String name;
        private Country country;

        public Builder id(String id){
            this.id = id;
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
            this.id = city.id;
            this.name = city.id;
            this.country = city.country;
            return this;
        }

        public City build(){return new City(this);}
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
