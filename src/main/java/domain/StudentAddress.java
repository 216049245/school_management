/*
StudentAddress.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class StudentAddress {

    @NotNull
    @Id
    private String studentId;

    @Embedded
    private  Address address;

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

        public StudentAddress.Builder copy(StudentAddress studentAddress){
            this.studentId = studentAddress.studentId;
            this.address = studentAddress.address;
            return this;
        }

        public StudentAddress build() {
            return new StudentAddress(this);
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StudentAddress that = (StudentAddress) obj;
        return studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
