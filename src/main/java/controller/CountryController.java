/* CountryController.java JPA controller
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package controller;

import domain.Country;
import domain.Name;
import domain.Student;
import factory.CountryFactory;
import factory.NameFactory;
import factory.StudentFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import service.ICountryService;
import service.IStudentService;

import java.util.List;

@RestController
@RequestMapping("/country/")
@Slf4j
public class CountryController {

    private final ICountryService iCountryService;


    @Autowired
    public CountryController(ICountryService iCountryService) {
        this.iCountryService = iCountryService;
    }

    //SAVE
    @PostMapping("save")
    public ResponseEntity<Country> save(@RequestBody Country country) {
        log.info("Save request:{}", country);

        Country ValidateC;
        try {
            ValidateC = CountryFactory.createCountryFactory(country.getId(), country.getName());
        } catch (IllegalArgumentException i) {
            log.info("Save error:{}", i.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Country save = iCountryService.save(ValidateC);
        return ResponseEntity.ok(save);
    }


    //READ
    @GetMapping("read/{studentId}")
    public ResponseEntity<Country> read(@PathVariable String countryId) {
        log.info("Read request:{}", countryId);
        Country country = this.iCountryService.read(countryId)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(country);
    }

    //DELETE
    @DeleteMapping("delete/{id}")
    public  ResponseEntity<Void>deleteById(@PathVariable String id) {
        log.info("Read request:{}",id);
        this.iCountryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //FINDALL
    @GetMapping("all")
    public ResponseEntity<List<Country>> findAll() {
        List<Country> country = this.iCountryService.findAll();
        return ResponseEntity.ok(country);
    }


}
