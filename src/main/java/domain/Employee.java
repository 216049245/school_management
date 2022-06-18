/*
Employee.java
Author: Brandon Lee Kruger (216049245)
Date: 15 June 2022
Edited 18 June 2022
*/

package domain;

import lombok.AllArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@AllArgsConstructor
@Table(name="Employee")
@Entity
public class Employee {

    @Id
    @NotNull
    @Column(name="staffId")
    private String staffID;
    @Column(name="email")
    private String email;
    @Embedded
    @Column(name="EmpName")
    private Name name;

    protected Employee(){}
    //@OneToOne(mappedBy = "EmpAddress", cascade = CascadeType.ALL) //
    //@PrimaryKeyJoinColumn //private EmployeeAddressAddress employeeAddressAddress;


    //Builder Class
    private Employee(Builder builder){
        this.staffID = builder.staffID;
        this.email = builder.email;
        this.name = builder.name;
    }

// Getters
    public String getStaffID() {return staffID; }

    public String getEmail() {return email; }

    public Name getName() {return name; }

    public static class Builder {
        private String staffID, email;
        private Name name;

        public Builder staffID(String staffID){
            this.staffID = staffID;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder name(Name name) {
            this.name = name;
            return this;
        }
        public Builder copy (Employee employee) {
            this.staffID = employee.staffID;
            this.email = employee.email;
            this.name = employee.name;
            return this;
        }
        public Employee build() { return new Employee(this);}
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
                ", name='" + name + '\'' +
                '}';
    }



    }





