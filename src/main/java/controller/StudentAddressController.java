/*
StudentAddressController.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package controller;

import domain.Address;
import domain.City;
import domain.Country;
import domain.StudentAddress;
import factory.AddressFactory;
import factory.CityFactory;
import factory.CountryFactory;
import factory.StudentAddressFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import service.IStudentAddressService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("SchoolManagement/student-address/")
@Slf4j
public class StudentAddressController {


    private final IStudentAddressService iStudentAddressService;

    @Autowired
    public StudentAddressController(IStudentAddressService studentAddressService) {
        this.iStudentAddressService = studentAddressService;
    }

    //SAVE
    @PostMapping("save")
    public ResponseEntity<StudentAddress> save(@Valid @RequestBody StudentAddress studentAddress){
        log.info("Save request: {}", studentAddress);
        StudentAddress save = null;
        try{
            Country validatedCountry = CountryFactory.createCountryFactory(studentAddress.getAddress().getCity().getCountry().getCountryId(), studentAddress.getAddress().getCity().getCountry().getCountryName());
            City validatedCity = CityFactory.createCityFactory(studentAddress.getAddress().getCity().getId(), studentAddress.getAddress().getCity().getName(), validatedCountry);
            Address address = AddressFactory.createAddress(
                    studentAddress.getAddress().getUnitNumber(),
                    studentAddress.getAddress().getComplexName(),
                    studentAddress.getAddress().getStreetNumber(),
                    studentAddress.getAddress().getStreetName(),
                    studentAddress.getAddress().getPostalCode(),
                    validatedCity);
            StudentAddress validatedStudentAddress = StudentAddressFactory.build(studentAddress.getStudentId(), address);
            save = iStudentAddressService.save(validatedStudentAddress);
        }catch(IllegalArgumentException exception)
        {
            log.info("EmployeeAddress Save : {}", exception);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(save);
    }

    //READ
    @GetMapping("read/{id}")
    public ResponseEntity<StudentAddress> read(@PathVariable String id){
        log.info("Read request: {}", id);
        StudentAddress studentAddress = this.iStudentAddressService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(studentAddress);
    }

    //DELETE
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request{}", id);
        this.iStudentAddressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //FIND ALL
    @GetMapping("all")
    public ResponseEntity<List<StudentAddress>> findAll(){
        List<StudentAddress> studentAddressList = this.iStudentAddressService.findAll();
        return ResponseEntity.ok(studentAddressList);
    }

}
