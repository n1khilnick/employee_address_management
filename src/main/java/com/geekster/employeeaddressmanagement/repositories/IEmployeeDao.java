package com.geekster.employeeaddressmanagement.repositories;

import com.geekster.employeeaddressmanagement.models.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeDao extends CrudRepository<Employee,Long> {


    @Modifying
    @Query(value = "update employee set first_name = :firstName, last_name = :lastName where employee_id = :employeeId",nativeQuery = true)
    void updateEmployeeNameById(Long employeeId, String firstName, String lastName);
}
