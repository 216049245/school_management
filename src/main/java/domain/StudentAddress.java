/*
StudentAddress.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class StudentAddress {

    @NotNull
    @Id
    private String studentId;

    @NotNull
    private  Address address;

    /*
     * private Address address;
     * Need Lutho to finish the Address.java entity
     * in order to inherit
     * the "Address" attributes
     */

    //changed from private to protected
    protected StudentAddress() {}

    //Builder
    private StudentAddress(Builder builder) {

        this.studentId = builder.studentId;
        this.address = builder.address;

    }

    //Getters
    public String getStudentId() {
        return studentId;
    }

    public Address getAddress() {
        return address;
    }

    //Builder static Class
    public static class Builder {

        private String studentId;
        private  Address address;

        public Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public StudentAddress build() {
            return new StudentAddress(this);
        }
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
