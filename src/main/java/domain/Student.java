package domain;

public class Student {

    private final String
            studentId,
            email,
            name;

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

    public String getName() {
        return name;
    }

    //Builder static Class
    public static class Builder {

        private String
                studentId,
                email,
                name;

        public Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
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
