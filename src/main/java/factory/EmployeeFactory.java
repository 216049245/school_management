/*
EmployeeFactory.java
Author: Brandon Lee Kruger (216049245)
Date: 16 June 2022
*/

package factory;
import domain.Employee;

public class EmployeeFactory {

    public static Employee build(String staffId, String email, String name) {
        return new Employee.Builder().staffID(staffId)
                .name(name)
                .email(email)
                .build();
    }
}