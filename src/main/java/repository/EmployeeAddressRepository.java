package repository;

import domain.Address;
import domain.EmployeeAddress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeAddressRepository
{   //Responsible for CRUD into a datastore
    //...need a singleton...
    private final List<EmployeeAddress> employeeAddressList;
    public static EmployeeAddressRepository EMPLOYEEADDRESS_REPOSITORY;

    private EmployeeAddressRepository()
    {
        this.employeeAddressList = new ArrayList<>();
    }

    public static EmployeeAddressRepository employeeAddressRepository()
    {
        if (EMPLOYEEADDRESS_REPOSITORY == null)

            EMPLOYEEADDRESS_REPOSITORY = new EmployeeAddressRepository();
            return EMPLOYEEADDRESS_REPOSITORY;

    }

    public EmployeeAddress create(EmployeeAddress employeeAddress)
    {
        //save into datastore and return
        this.employeeAddressList.add(employeeAddress);
        return employeeAddress;
    }

    public EmployeeAddress update(EmployeeAddress employeeAddress)
    {
        //check of employee address exists, if yes, update and return if successful

        Optional <EmployeeAddress> read = read(employeeAddress.getStaffID());
        if (read.isPresent())
        {
            delete(read.get());
            create(employeeAddress);
        }

        return employeeAddress;
    }

    public Optional<EmployeeAddress> read(String staffId)
    {
        //find the employee address that matches the staffId and return
        return this.employeeAddressList.stream().filter(g -> g.getStaffID().equalsIgnoreCase(staffId)).findFirst(); //can use findAny or findFirst
    }

    public void delete(EmployeeAddress employeeAddress)
    {
        //finds the employee address if needed and deletes.
        this.employeeAddressList.remove(employeeAddress);
    }

    public List<EmployeeAddress> findALl()
    {   //return all in your store
        return this.employeeAddressList;
    }
}
