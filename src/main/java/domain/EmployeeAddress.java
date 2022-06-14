package domain;

import java.util.Objects;

public class EmployeeAddress{
    //globals;
    private final String staffID;
    private final Address address;


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

