package factory;

import domain.EmployeeAddress;
import domain.Address;
import service.StringHelper;

public class EmployeeAddressFactory
{

    public static EmployeeAddress build(String staffId, Address address)
    {
        StringHelper.checkStringParam("staffId",staffId);
        if( address == null)
            //tell the user that they must provide an address
            throw new IllegalArgumentException("Address is required!");

        return new EmployeeAddress.Builder().staffId(staffId).address(address).build();
    }
}
