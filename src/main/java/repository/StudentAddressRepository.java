package repository;


import domain.StudentAddress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentAddressRepository implements IStudentAddressRepository{

    //Implement singleton
    private final List<StudentAddress> studentAddressList;
    private static StudentAddressRepository STUDENT_ADDRESS_REPO;

    private StudentAddressRepository () {
        this.studentAddressList = new ArrayList<>();
    }

    public static StudentAddressRepository studentAddressRepository() {
        if (STUDENT_ADDRESS_REPO == null)
            STUDENT_ADDRESS_REPO = new StudentAddressRepository();
        return STUDENT_ADDRESS_REPO;
    }

    //Create and Update into Save
    public StudentAddress save(StudentAddress studentAddress) {
        //Update
        Optional<StudentAddress> read = read(studentAddress.getStudentId());
        if (read.isPresent()) {
            delete(read.get());
        }
        //Create
        this.studentAddressList.add(studentAddress);
        return  studentAddress;
    }


    //Read
    //"Optional <method>..." prevents a return of null
    public Optional<StudentAddress> read(String studentId) {
        //find student that matches the student id and return
        return this.studentAddressList.stream().filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                .findAny();

    }

    //Delete
    //@Override
    public void delete(StudentAddress studentAddress) {
        this.studentAddressList.remove(studentAddress);

    }

    //Find All
    public List<StudentAddress> findAll() {
        //returns all the stored students
        return this.studentAddressList;
    }


    @Override
    public StudentAddress create(StudentAddress studentAddress) {
        return null;
    }

    @Override
    public StudentAddress update(StudentAddress studentAddress) {
        return null;
    }

}
