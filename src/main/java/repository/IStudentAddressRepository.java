package repository;


import domain.StudentAddress;

import java.util.List;

public interface IStudentAddressRepository extends IRepository<StudentAddress, String>{

    List<StudentAddress> findAll();
}
