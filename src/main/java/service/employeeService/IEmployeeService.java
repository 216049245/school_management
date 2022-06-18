package service.employeeService;

import domain.Employee;
import service.IService;

import java.util.List;

public interface IEmployeeService extends IService<Employee, String> {
    void delete(Employee employeeId);

    List<Employee> findAll();

    void deleteById(String id);
}
