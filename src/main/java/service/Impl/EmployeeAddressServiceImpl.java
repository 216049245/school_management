package service.Impl;

import domain.EmployeeAddress;
import org.springframework.stereotype.Service;
import repository.EmployeeAddressRepository;
import service.EmployeeAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService{

    private EmployeeAddressRepository repository;


    public EmployeeAddressServiceImpl(EmployeeAddressRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress)
    {
        return this.repository.save(employeeAddress);
    }

    @Override
    public Optional<EmployeeAddress> read(String s)
    {
        return this.repository.read(s);
    }

    @Override
    public void delete(EmployeeAddress employeeAddress){this.repository.delete(employeeAddress);}

    @Override
    public List<EmployeeAddress> findAll(){return this.repository.findAll();}

    @Override
    public void deleteByStaffId(String staffId)
    {
        Optional<EmployeeAddress> employeeAddress = read(staffId);
        if (EmployeeAddress.isPresent()) delete(employeeAddress.get());
    }
}
