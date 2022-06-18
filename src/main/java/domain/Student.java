/*
Student.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/
package domain;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@AllArgsConstructor
@Entity
@Table(name = "Students")
public class Student {

    @NotNull
    @Id
    @Column(name = "studentId")
    private String studentId;


    @Column(name = "studentEmal")
    private String email;

    @Embedded
    @Column(name = "studentName")
    private Name name;

    //changed from private to protected
    protected Student() {}

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

        private String studentId;
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

        public Builder copy(Student student){
            this.studentId = student.studentId;
            this.email = student.email;
            this.name = student.name;
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