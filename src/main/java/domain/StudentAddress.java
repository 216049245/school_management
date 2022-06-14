
package domain;


public class StudentAddress {

    private String studentId;
    private  String address;

    /*
     * private Address address;
     * Need Lutho to finish the Address.java entity
     * in order to inherit
     * the "Address" attributes
     */

    //Builder class
    private StudentAddress(Builder builder) {

        this.studentId = builder.studentId;
        this.address = builder.address;

    }

    //Getters
    public String getStudentId() {
        return studentId;
    }

    public String getAddress() {
        return address;
    }

    //Builder static Class
    public static class Builder {

        private String studentId;
        private  String address;

        public Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder address(String address) {
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
