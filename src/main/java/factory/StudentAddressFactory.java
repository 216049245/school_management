/*
StudentAddressFactory.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package factory;

import domain.Address;
import domain.StudentAddress;
import service.StringHelper;

public class StudentAddressFactory {


    public static StudentAddress build(String studentId, Address address) {

        //Inform caller of the missing studentId
        if (studentId == null || studentId.isEmpty())
            throw new IllegalArgumentException("Student ID is required!");

        //Inform caller of the missing email
        if (address == null )
            throw new IllegalArgumentException("Student address is required!");

        StringHelper.checkStringParam("studentId", studentId);
        //StringHelper.checkId(studentId);

        return new StudentAddress.Builder().studentId(studentId)
                .address(address)
                .build();
    }
}