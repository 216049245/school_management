package factory;

import domain.StudentAddress;

public class StudentAddressFactory {


    public static StudentAddress createStudentAddress(String studentId, String address) {

        StudentAddress StudentAddress =  new StudentAddress.Builder().studentId(studentId)
                .address(address)
                .build();
        return StudentAddress;
    }
}