/*

package repository;

import domain.Student;
import factory.StudentFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {
    private Student student;
    private StudentRepository repository;

    @BeforeEach void setUp() {
        this.student = StudentFactory.build("test-StudentId", "test-student");
        this.repository = StudentRepository.studentRepository();
        //Test Save
        Student saved =  this.repository.save(this.student);
        assertEquals(this.student, saved);
    }

    //Test Delete
    @AfterEach void tearDown() {
        this.repository.delete(this.student);
        List<Student> studentList = this.repository.findAll();
        assertEquals(0, studentList.size());
    }

    //Test Read
    @Test
    void read() {
        Optional<Student> read = this.repository.read(this.student.getStudentId());
        assertTrue(read.isPresent());
    }


    @Test
    void findAll() {
        List<Student> studentList = this.repository.findAll();
        assertEquals(1, studentList.size());

    }


}

 */