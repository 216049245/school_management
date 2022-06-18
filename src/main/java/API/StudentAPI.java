package API;

import domain.Student;
import domain.StudentAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import service.IStudentAddressService;
import service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentAPI {

    private final IStudentService studentService;
    private final IStudentAddressService iStudentAddressService;


    @Autowired
    public StudentAPI(IStudentService studentService, IStudentAddressService studentAddressService) {
        this.studentService = studentService;
        this.iStudentAddressService = studentAddressService;

    }

    public List<String> findStudentsInCountry(String countryId){
        try {
            List<StudentAddress> allStudentAddresses = iStudentAddressService.findAll();
            List<StudentAddress> filteredStudentAddress = new ArrayList<>();
            List<Student> allStudents = new ArrayList<>();
            List<String> lastNames = new ArrayList<>();

            for (var studentAddress: allStudentAddresses) {
                if (studentAddress.getAddress().getCity().getCountry().getCountryId().equalsIgnoreCase(countryId)){
                    filteredStudentAddress.add(studentAddress);
                }
            }

            filteredStudentAddress.forEach(studentAddress -> {
                allStudents.add(studentService.read(studentAddress.getStudentId()).get());
            });

            allStudents.forEach(student -> {
                lastNames.add(student.getName().getLastName());
            });

            return lastNames;

        }catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
