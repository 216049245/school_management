/*
StudentAddress.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package domain;


public class StudentAddress {

    private final String studentId;
    private  Address address;

    /*
     * private Address address;
     * Need Lutho to finish the Address.java entity
     * in order to inherit
     * the "Address" attributes
     */

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
