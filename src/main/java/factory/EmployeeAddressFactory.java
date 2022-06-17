/*
 *   Entity: EmployeeAddress.java
 *   Author: Jesse Merold Hiebner
 *   Date: 14/06/2022
 */
package factory;

import domain.EmployeeAddress;
import service.StringHelper;

public class EmployeeAddressFactory
{

    public static EmployeeAddress build(String staffId, String address)
    {
        StringHelper.checkStringParam("staffId",staffId);
        if( address == null)
            //tell the user that they must provide an address
            throw new IllegalArgumentException("Address is required!");

        return new EmployeeAddress.Builder().staffId(staffId).address(address).build();
    }

    public static EmployeeAddress.EmployeeAddressId buildId(EmployeeAddress employeeAddress)
    {
        return new EmployeeAddress.EmployeeAddressId(employeeAddress.getStaffID()); //gives ID for that instance
    }
}
