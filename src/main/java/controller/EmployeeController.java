/**
package controller;

import domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.EmployeeRepository;

@RestController
@RequestMapping("/api/z")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();

        @GetMapping

        public List<Employee> getAllEmployees(){
            return employeeRepository.findAll();
        }
    }
}
*/