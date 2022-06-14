package domain;

import java.util.Objects;

public class Employee {

    private final String staffID, email, firstName, lastName;
    private Employee(Builder builder){
        this.staffID = builder.staffID;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getStaffID() {return staffID; }

    public String getEmail() {return email; }

    public String getFirstName() {return firstName; }

    public String getLastName() {return lastName; }

    public static class Builder {
        private String staffID, email, firstName, lastName;

        public Builder staffID(String staffID){
            this.staffID = staffID;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return staffID.equals(employee.staffID);
    }

    @Override
    public int hashCode() { return Objects.hash(staffID); }

    @Override
    public String toString() {
        return "Employee{" +
                "staffID='" + staffID + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }



    }





