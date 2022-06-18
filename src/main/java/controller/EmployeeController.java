/*
EmployeeController.java
Author: Brandon Kruger (216049245)
Date: 18 June 2022
*/

package controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import domain.Employee;
import domain.Name;
import factory.EmployeeFactory;
import factory.NameFactory;
import service.employeeService.IEmployeeService;
import java.util.List;

@RestController
@RequestMapping("/employee/")
@Slf4j
public class EmployeeController {

    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        log.info("Save request: {}", employee);
        Name validatedName;
        Employee validatedEmployee;
        try {
            validatedName = NameFactory.buildName(employee.getName().getFirstName(),
                    employee.getName().getMiddleName(),employee.getName().getLastName());
            validatedEmployee = EmployeeFactory.build(employee.getStaffId(),
                    employee.getEmail(), validatedName);
        }catch(IllegalArgumentException e){
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Employee save = employeeService.save(validatedEmployee);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request{}", id);
        this.employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Employee> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Employee employee = this.employeeService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee);
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> employeeList = this.employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }
}