/*
EmployeeFactory.java
Author: Brandon Lee Kruger (216049245)
Date: 16 June 2022
*/

package factory;
import domain.Employee;
import domain.Name;
import helper.GenericHelper;

public class EmployeeFactory {

    public static Employee build(String staffId, String email, Name name) {

        GenericHelper.checkStringParam("Staff Id", staffId);
        GenericHelper.checkStringParam("Email", email);
        GenericHelper.checkEmail(email); //Create in GenericHelper
        GenericHelper.checkIfObjectNull("Name",name);

        return new Employee.Builder().staffId(staffId).email(email).name(name).build();
    }
}