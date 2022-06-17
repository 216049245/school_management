package factory;

import domain.StudentAddress;

public class StudentAddressFactory {


    public static StudentAddress build(String studentId, String address) {

        return new StudentAddress.Builder().studentId(studentId)
                .address(address)
                .build();
    }
}