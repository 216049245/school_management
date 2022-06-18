/*
StudentController.java
Author: Monehi Tuoane (219350744)
Date: 18 June 2022
*/

package controller;

import domain.Name;
import domain.Student;
import factory.NameFactory;
import factory.StudentFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import service.IStudentService;

import java.util.List;

@RestController
@RequestMapping("SchoolManagement/student/")
@Slf4j
public class StudentController {

    private final IStudentService istudentService;


    @Autowired
    public StudentController(IStudentService iStudentService ) {
        this.istudentService = iStudentService;
    }

    //SAVE
    @PostMapping("save")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        log.info("Save request:{}", student);
        Name ValidateN;
        Student ValidateS;
        try {
            ValidateN = NameFactory.buildName(student.getName().getFirstName(),
                    student.getName().getMiddleName(), student.getName().getLastName());

            ValidateS = StudentFactory.build(student.getStudentId(), student.getEmail(), ValidateN);
        } catch (IllegalArgumentException i) {
            log.info("Save error:{}", i.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Student save = istudentService.save(ValidateS);
        return ResponseEntity.ok(save);
    }


    //READ
    @GetMapping("read/{studentId}")
    public ResponseEntity<Student> read(@PathVariable String studentId) {
        log.info("Read request:{}", studentId);
        Student student = this.istudentService.read(studentId)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student);
    }

    //DELETE
    @DeleteMapping("delete/{id}")
    public  ResponseEntity<Void>deleteById(@PathVariable String id) {
        log.info("Read request:{}",id);
        this.istudentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //FINDALL
    @GetMapping("all")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> student = this.istudentService.findAll();
        return ResponseEntity.ok(student);
    }



}


