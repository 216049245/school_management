package controller;

import domain.*;
import factory.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import service.IStudentAddressService;
import service.IStudentService;

import java.util.List;

@RestController
@RequestMapping("SchoolManagement/Address/")
@Slf4j
public class AddressController {
    private final IStudentAddressService iStudentAddressService;


    @Autowired
    public AddressController(IStudentAddressService iStudentAddressService ) {
        this.iStudentAddressService = iStudentAddressService;
    }

    //SAVE
    @PostMapping("save")
    public ResponseEntity<StudentAddress> save(@RequestBody Address address) {
        log.info("Save request:{}", address);
        Address ValidateA;
        City ValidateC;
        Country ValidateCo;
        StudentAddress ValidateS;
        try {
            StudentAddress st;
            ValidateCo = CountryFactory.createCountryFactory(address.getCity().getCountry().getId(), address.getCity().getCountry().getName());
            ValidateC = CityFactory.createCityFactory(address.getCity().getId(), address.getCity().getName(),address.getCity().getCountry() );
            ValidateA = AddressFactory.createAddress(address.getUnitNumber(),
                    address.getComplexName(), address.getStreetNumber(), address.getStreetName(), address.getPostalCode(), address.getCity());
//            ValidateS = StudentAddressFactory.build(st.getStudentId(),address);
        } catch (IllegalArgumentException i) {
            log.info("Save error:{}", i.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
//        Address save = iStudentAddressService.save(ValidateA);
//        return ResponseEntity.ok(save);
        return null;
    }}


//    //READ
//    @GetMapping("read/{studentId}")
//    public ResponseEntity<Student> read(@PathVariable String studentId) {
//        log.info("Read request:{}", studentId);
//        Student student = this.istudentService.read(studentId)
//                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        return ResponseEntity.ok(student);
//    }
//
//    //DELETE
//    @DeleteMapping("delete/{id}")
//    public  ResponseEntity<Void>deleteById(@PathVariable String id) {
//        log.info("Read request:{}",id);
//        this.istudentService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    //FINDALL
//    @GetMapping("all")
//    public ResponseEntity<List<Address>> findAll() {
//        List<Address> student = this.iStudentAddressService.findAll();
//        return ResponseEntity.ok(address);
//    }
//}
