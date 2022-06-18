/*
Student.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/
package domain;

import java.util.Objects;

public class Student {

    private final String
            studentId,
            email;

    private Name name;

    /*
     * private Name name;
     * Need Sipiwe to finish the Name.java entity
     * in order to inherit
     * the "Name" attributes
     */




    //Builder Class
    private Student(Builder builder) {

        this.studentId = builder.studentId;
        this.email = builder.email;
        this.name = builder.name;

    }

    //Getters
    public String getStudentId() {
        return studentId;
    }

    public String getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    //Builder static Class
    public static class Builder {

        private String
                studentId;
        private Name name;
        private String email;

        public Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder name(Name name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }


        public Student build() {
            return new Student(this);
        }
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student that = (Student) obj;
        return studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
