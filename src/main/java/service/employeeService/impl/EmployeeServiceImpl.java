package service.employeeService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import domain.Employee;
import repository.IEmployeeRepository;
import service.employeeService.IEmployeeService;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository repository;

    @Autowired public EmployeeServiceImpl(IEmployeeRepository repository){
        this.repository = repository;
    }

    @Override
    public Employee save(Employee employee) {return this.repository.save(employee);}

    @Override
    public Optional<Employee> read(String id) {
        return this.repository.findById(id);
    }

    @Override
    public Employee findById(String s) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void delete(Employee employeeId) {
        this.repository.delete(employeeId);
    }

    @Override
    public List<Employee> findAll() {
        return this.repository.findAll();
    }

    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<Employee> employee = read(id);
        if (employee.isPresent()) {
            delete(employee.get());
        }
    }
}
