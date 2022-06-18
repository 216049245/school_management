/*
 *   Entity: EmployeeAddress.java
 *   Author: Jesse Merold Hiebner
 *   Date: 14/06/2022
 */

package domain;

import java.util.Objects;
import domain.Address;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//@NoArgsConstructor
@AllArgsConstructor
@Table(name="EmployeeAddress")
@Entity

/*@OneToOne(mappedBy = "staffId", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;
* */



public class EmployeeAddress{
    //globals;
    @Id
    @NotNull
    @Column(name = "staffId")
    private String staffID;

    @OneToOne
    @MapsId
    @JoinColumn(name="staffId")
    private Employee employee;


    @Embedded
    private Address address; //change to address when you are able to. EVERYWHERE


    private EmployeeAddress(Builder builder)
    {
        this.staffID = builder.staffId;
        this.address = builder.address;
    }

    public String getStaffID(){return staffID;}
    public Address getAddress(){return address;}

    public static class Builder
    {
        private String staffId;
        private Address address;

        public Builder staffId(String staffId)
        {
            this.staffId = staffId;
            return this;
        }

        public Builder address(Address address)
        {
            this.address = address;
            return this;
        }

        public Builder copy(EmployeeAddress employeeAddress)
        {
            this.staffId = employeeAddress.staffID;
            this.address = employeeAddress.address;
            return this;
        }

        public EmployeeAddress build()
        {
            return new EmployeeAddress(this);
        }
    }

    //Inner Class
    public static class EmployeeAddressId
    { //Immutable Object. Not used. Don't have composite key
        private String staffId;

        public EmployeeAddressId(String staffId) {
            this.staffId = staffId;
        }

        public String getStaffId() {
            return staffId;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EmployeeAddressId that = (EmployeeAddressId) o;
            return staffId.equals(that.staffId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(staffId);
        }
    }

    public boolean equals(Object o)
    {
        if(this == o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeAddress that = (EmployeeAddress) o;
        return true;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffID='" + staffID + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

