/* CityController.java JPA controller
   Author: Guy De La Cruz (218336969)
   Date: 11/04/2022
   */
package controller;
//
import domain.City;
import factory.CityFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import service.ICityService;


import java.util.List;

@RestController
@RequestMapping("/city/")
@Slf4j
public class CityController {

    private final ICityService iCityService;


    @Autowired
    public CityController(ICityService iCityService ) {this.iCityService = iCityService;}

    //SAVE
    @PostMapping("save")
    public ResponseEntity<City> save(@RequestBody City city) {
        log.info("Save request:{}", city);
        City ValidateS;
        try {

            ValidateS = CityFactory.createCityFactory(city.getId(), city.getName(), city.getCountry());
        } catch (IllegalArgumentException i) {
            log.info("Save error:{}", i.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        City save = iCityService.save(ValidateS);
        return ResponseEntity.ok(save);
    }


    //READ
    @GetMapping("read/{studentId}")
    public ResponseEntity<City> read(@PathVariable String cityId) {
        log.info("Read request:{}", cityId);
        City city = this.iCityService.read(cityId)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(city);
    }

    //DELETE
    @DeleteMapping("delete/{id}")
    public  ResponseEntity<Void>deleteById(@PathVariable String cityId) {
        log.info("Read request:{}",cityId);
        this.iCityService.deleteById(cityId);
        return ResponseEntity.noContent().build();
    }

    //FINDALL
    @GetMapping("all")
    public ResponseEntity<List<City>> findAll() {
        List<City> city = this.iCityService.findAll();
        return ResponseEntity.ok(city);
    }

}
