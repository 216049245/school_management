package service;

import domain.EmployeeAddress;

import java.util.List;
import java.util.Optional;

public interface EmployeeAddressService
{

    EmployeeAddress save(EmployeeAddress employeeAddress);

    Optional<EmployeeAddress> read(String s);

    void delete(EmployeeAddress employeeAddress);

    List<EmployeeAddress> findAll();

    void deleteByStaffId(String StaffId);
}
