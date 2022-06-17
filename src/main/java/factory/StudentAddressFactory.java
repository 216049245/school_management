/*
StudentAddressFactory.java
Author: Monehi Tuoane (219350744)
Date: 17 June 2022
*/

package factory;

import domain.StudentAddress;

public class StudentAddressFactory {


    public static StudentAddress build(String studentId, String address) {

        //Inform caller of the missing studentId
        if (studentId == null || studentId.isEmpty())
            throw new IllegalArgumentException("Student ID is required!");

        //Inform caller of the missing email
        if (address == null || address.isEmpty())
            throw new IllegalArgumentException("Student address is required!");


        return new StudentAddress.Builder().studentId(studentId)
                .address(address)
                .build();
    }
}