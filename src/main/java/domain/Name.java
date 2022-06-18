package domain;
/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Name {

    private String firstName, middleName, lastName;

    public Name(){
    }

    public Name(Builder builder) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }
        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Name name = (Name) o;
            return firstName.equals(name.firstName) && middleName.equals(name.middleName) && lastName.equals(name.lastName);
        }

        @Override
        public int hashCode () {
            return Objects.hash(firstName, middleName, lastName);
        }


        public static class Builder {
            private String firstName, middleName, lastName;

            public Builder firstName(String firstName) {
                this.firstName = firstName;
                return this;
            }

            public Builder middleName(String middleName) {
                this.middleName = middleName;
                return this;
            }

            public Builder lastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public Builder build(Name name) {
                this.firstName = name.firstName;
                this.middleName = name.middleName;
                this.lastName = name.lastName;
                return this;
            }

            public Name build() {
                return new Name(this);
            }

        }
    }

